package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.example.model.Example;
import com.shawn.learningalways.example.model.YmlProperties;
import com.shawn.learningalways.example.service.ExampleService;
import com.shawn.learningalways.example.task.AsyncTasks;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 系统名称: learningAlways
 * 模块名称: 测试模块
 * 类 名 称: Example
 * 软件版权: shawn
 * 功能说明：测试http请求
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/6/7 21:31
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
public class ExampleController extends BaseController{

    /**
     * 要取属性值的对象必须注入到spring中，否则也取不到值
     */
    @Autowired
    private YmlProperties ymlProperties;
    /**
     *  异步任务
     */
    @Autowired
    private AsyncTasks asyncTasks;
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 示例service
     */
    @Autowired
    ExampleService exampleService;


    /**
     * @Description 每个工程都应该有个Hello World
     * @param
     * @return
     * @date 2019/3/21 22:22
     * @author Shawn Wu
     */
    @RequestMapping("/hello")
    public String hello() {

        return "Hello World!";
    }

    /**
     * @Description 测试redis
     * @param
     * @return
     * @date 2019/3/21 22:25
     * @author Shawn Wu
     */
    @RequestMapping("/redisTest")
    public String redisTest() {
        redisTemplate.opsForValue().set("redisTest", "success");
        String success = (String)redisTemplate.opsForValue().get("redisTest");
        System.out.println("测试redis: " + success);
        redisTemplate.delete("redisTest");
        return success;
    }

    @RequestMapping("/config")
    public String config() {
//        YmlProperties ymlProperties = new YmlProperties(); //直接new的取不到属性值
        StringBuilder sb = new StringBuilder();
        sb.append("读的配置文件是：" + ymlProperties.getActive() + "\n");
        sb.append("这个是直接赋值的：" + ymlProperties.getText() + "\n");
        sb.append("读取dev配置中的值：" + ymlProperties.getDesc() + "\n");
        sb.append("dev配置中的端口是：" + ymlProperties.getPort());
        return sb.toString();
    }

    @RequestMapping("/exceptionTest")
    public String exceptionTest(){
        int[] a = new int[10];
        int qqq = a[12];
        System.out.println("这里越界了" + qqq);
        return "sdfa";
//        throw new CommonException("抛出一个异常");
    }

    @RequestMapping("/renderTest")
    public JsonResult renderTest(int flag){
        if(0==flag){
           return renderError("返回错误");
        }
        return renderSuccess("返回成功");
    }

    @RequestMapping("/asyncTest")
    public void asyncTest(){

        long startTime = System.currentTimeMillis();

        // 执行任务一
        asyncTasks.doTaskOne();
        // 执行任务二
        Future<String> task2 = asyncTasks.doTaskTwo();
        // 执行任务三
        Future<String> task3 = asyncTasks.doTaskThree();

        // 等待任务二和任务三完成
        while(true){
            if(task2.isDone() && task3.isDone()){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("任务二和任务三都完成了，耗时：" + (endTime - startTime) + "毫秒");
    }

    @RequestMapping("/asyncExecutorTest")
    public void asyncExecutorTest() throws Exception{
        asyncTasks.doTaskExecutorOne(); //执行任务一
        asyncTasks.doTaskExecutorTwo(); //执行任务二
        asyncTasks.doTaskExecutorThree(); //执行任务三
        Thread.currentThread().join();
    }

    /**
     * @Description 获取example列表
     * @param
     * @return 
     * @date 2019/3/27 18:18
     * @auther Shawn Wu
     */
    @RequestMapping("/getExampleList")
    public JsonResult getExampleList(){
        List<Example> exampleList = exampleService.getExampleList();
        return renderSuccess(exampleList);
    }

    public static void main(String[] args) {
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }
}

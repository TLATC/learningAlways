package com.shawn.learningalways.example.controller;

import com.github.pagehelper.PageHelper;
import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.base.model.PageBean;
import com.shawn.learningalways.example.annotation.TestAnnotation;
import com.shawn.learningalways.example.model.Example;
import com.shawn.learningalways.example.model.YmlProperties;
import com.shawn.learningalways.example.service.ExampleService;
import com.shawn.learningalways.example.task.AsyncTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/example")
public class ExampleController extends BaseRender {

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
    public JsonResult exceptionTest(int flag){
        switch (flag){
            case 0:
                throw new NullPointerException();
            case 1:
                throw new ArrayIndexOutOfBoundsException();
            case 2:
                throw new ClassCastException();
            case 3:
                throw new NumberFormatException();
            default:
                throw new CommonException("测试CommonException");
        }
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
     * @Description 测试自定义注解
     * @param
     * @return
     * @date 2019/5/6 11:44
     * @auther Shawn Wu
     */
    @RequestMapping("/annotationTest")
    @TestAnnotation
    public JsonResult annotationTest(){
        return renderSuccess();
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

    /**
     * @Description 分页获取example列表
     * @param pageBean 分页对象
     * @param example 示例实体类
     * @return
     * @date 2019/5/5 15:23
     * @auther Shawn Wu
     */
    @PostMapping("/getExampleListByPage")
    public JsonResult getExampleListByPage(PageBean<Example> pageBean, Example example){
        // 设置分页信息（必须在执行sql方法前设置）
        PageHelper.startPage(pageBean.getPageNo(), pageBean.getPageSize());
        // 获取满足条件的example列表
        List<Example> exampleList = exampleService.getExampleListByCondition(example);

        // 分页查询结果数据
        pageBean.setRecords(exampleList);
        // 总数据条数（总条数方法需要自己写）
        pageBean.setTotalNum(exampleService.getExampleCountByCondition(example));
        return renderSuccess(pageBean);
    }

    public static void main(String[] args) {
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }
}

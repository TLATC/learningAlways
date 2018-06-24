package com.jones.myspringboot.example.controller;

import com.jones.myspringboot.example.model.YmlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统名称: mySpringBoot
 * 模块名称: 测试模块
 * 类 名 称: Example
 * 软件版权: Jones
 * 功能说明：测试http请求
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/7 21:31
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
public class Example {

    @Autowired
    private YmlProperties ymlProperties; //要取属性值的对象必须注入到spring中，否则也取不到值

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
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
}

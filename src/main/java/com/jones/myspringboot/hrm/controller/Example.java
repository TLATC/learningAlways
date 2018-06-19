package com.jones.myspringboot.hrm.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统名称: WereWolf
 * 模块名称:
 * 类 名 称: Example
 * 软件版权: Jones
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/7 21:31
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/test")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}

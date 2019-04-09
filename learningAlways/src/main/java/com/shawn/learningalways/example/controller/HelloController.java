package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseController;
import oracle.jrockit.jfr.StringConstantPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: HelloController
 * 软件版权: Shawn Wu
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Shawn Wu
 * 开发时间: 2019/4/9 20:59
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
public class HelloController extends BaseController {

    /**
     * @Description 每个工程都应该有个Hello World
     * @param
     * @return
     * @date 2019/4/9 21:01
     * @author Shawn Wu
     */
    @RequestMapping("/helloWorld")
    public String hello(){
        return "Hello World!";
    }

}

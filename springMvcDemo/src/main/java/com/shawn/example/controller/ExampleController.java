package com.shawn.example.controller;

import com.shawn.base.controller.BaseController;
import com.shawn.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ExampleController
 * @Description 示例Controller
 * @author: Shawn Wu
 * @date: 2019/2/1 16:21
 * @version:
 */
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    @Autowired
    ExampleService exampleService;

    @RequestMapping("/hello")
    public String hello() {
        return exampleService.hello();
    }

}
package com.shawn.example.service.impl;

import com.shawn.example.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ExampleServiceImpl
 * @Description 示例service实现
 * @author: Shawn Wu
 * @date: 2019/2/1 16:48
 * @version:
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    /**
     * 示例方法 hello
     * @return
     */
    @Override
    public String hello() {
        return "Hello World";
    }
}
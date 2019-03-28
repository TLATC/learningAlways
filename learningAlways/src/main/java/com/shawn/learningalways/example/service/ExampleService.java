package com.shawn.learningalways.example.service;

import com.shawn.learningalways.example.model.Example;

import java.util.List;

/**
 * @ClassName: ExampleService
 * @Description service层示例
 * @author: Shawn Wu
 * @date: 2019/3/27 18:03
 * @version:
 */
public interface ExampleService {

    /**
     * @Description 获取example列表
     * @param
     * @return
     * @date 2019/3/27 18:04
     * @auther Shawn Wu
     */
    List<Example> getExampleList();
}

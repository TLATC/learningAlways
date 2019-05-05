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

    /**
     * @Description 根据条件查询example列表
     * @param example 示例实体类
     * @return
     * @date 2019/5/5 16:05
     * @auther Shawn Wu
     */
    List<Example> getExampleListByCondition(Example example);

    /**
     * @Description 获取满足条件的example数量
     * @param example 示例实体类
     * @return
     * @date 2019/5/5 16:10
     * @auther Shawn Wu
     */
    Integer getExampleCountByCondition(Example example);
}

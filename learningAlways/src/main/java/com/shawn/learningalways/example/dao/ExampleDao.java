package com.shawn.learningalways.example.dao;

import com.shawn.learningalways.example.model.Example;

import java.util.List;

/**
 * @ClassName: ExampleDao
 * @Description Dao层示例
 * @author: Shawn Wu
 * @date: 2019/3/27 17:31
 * @version:
 */
public interface ExampleDao {

    /**
     * @Description 获取example列表
     * @param
     * @return
     * @date 2019/3/27 17:35
     * @auther Shawn Wu
     */
    List<Example> getExampleList();
}

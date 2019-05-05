package com.shawn.learningalways.example.service.impl;

import com.shawn.learningalways.example.dao.ExampleDao;
import com.shawn.learningalways.example.model.Example;
import com.shawn.learningalways.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ExampleServiceImpl
 * @Description service实现层示例
 * @author: Shawn Wu
 * @date: 2019/3/27 18:05
 * @version:
 */
@Service
public class ExampleServiceImpl implements ExampleService{

    @Autowired
    ExampleDao exampleDao;

    /**
     * @Description 获取example列表
     * @param
     * @return
     * @date 2019/3/27 18:06
     * @auther Shawn Wu
     */
    @Override
    public List<Example> getExampleList() {
        return exampleDao.getExampleList();
    }

    /**
     * @Description 根据条件查询example列表
     * @param example 示例实体类
     * @return
     * @date 2019/5/5 16:06
     * @auther Shawn Wu
     */
    @Override
    public List<Example> getExampleListByCondition(Example example) {
        return exampleDao.getExampleListByCondition(example);
    }

    /**
     * @Description 获取满足条件的example数量
     * @param example 示例实体类
     * @return
     * @date 2019/5/5 16:12
     * @auther Shawn Wu
     */
    @Override
    public Integer getExampleCountByCondition(Example example) {
        return exampleDao.getExampleCountByCondition(example);
    }
}
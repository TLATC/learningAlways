package com.shawn.learningalways.mybatisgenerator.service;

import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDO;

import java.util.List;

/**
 * @ClassName: MybatisGeneratorService
 * @Description mybatis逆向工程服务层
 * @author: Shawn Wu
 * @date: 2019/11/24 14:34
 * @version:
 */
public interface MybatisGeneratorService {

    /**
     * @Description 新增数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 14:38
     * @auther Shawn Wu
     */
    String insertMyGenerator(MybatisGeneratorDO mybatisGeneratorDO);

    /**
     * @Description 根据id修改数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 14:38
     * @auther Shawn Wu
     */
    String updateMyGeneratorById(MybatisGeneratorDO mybatisGeneratorDO);

    /**
     * @Description 根据id删除数据
     * @param id
     * @return
     * @date 2019/11/24 14:39
     * @auther Shawn Wu
     */
    String deleteMyGeneratorById(String id);

    /**
     * @Description 查询符合条件的数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 14:39
     * @auther Shawn Wu
     */
    List<MybatisGeneratorDO> getMyGeneratorByCondition(MybatisGeneratorDO mybatisGeneratorDO);
}

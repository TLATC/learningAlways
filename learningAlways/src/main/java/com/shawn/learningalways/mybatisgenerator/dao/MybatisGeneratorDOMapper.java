package com.shawn.learningalways.mybatisgenerator.dao;

import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDO;
import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MybatisGeneratorDOMapper {
    int countByExample(MybatisGeneratorDOExample example);

    int deleteByExample(MybatisGeneratorDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(MybatisGeneratorDO record);

    int insertSelective(MybatisGeneratorDO record);

    List<MybatisGeneratorDO> selectByExample(MybatisGeneratorDOExample example);

    MybatisGeneratorDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MybatisGeneratorDO record, @Param("example") MybatisGeneratorDOExample example);

    int updateByExample(@Param("record") MybatisGeneratorDO record, @Param("example") MybatisGeneratorDOExample example);

    int updateByPrimaryKeySelective(MybatisGeneratorDO record);

    int updateByPrimaryKey(MybatisGeneratorDO record);

    /**
     * @Description 查询符合条件的数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 15:48
     * @auther Shawn Wu
     */
    List<MybatisGeneratorDO> getMyGeneratorByCondition(MybatisGeneratorDO mybatisGeneratorDO);
}
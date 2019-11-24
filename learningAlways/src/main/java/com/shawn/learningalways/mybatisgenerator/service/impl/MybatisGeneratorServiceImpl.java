package com.shawn.learningalways.mybatisgenerator.service.impl;

import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.mybatisgenerator.dao.MybatisGeneratorDOMapper;
import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDO;
import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDOExample;
import com.shawn.learningalways.mybatisgenerator.service.MybatisGeneratorService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: MybatisGeneratorServiceImpl
 * @Description mybatis逆向工程服务层实现
 * @author: Shawn Wu
 * @date: 2019/11/24 14:40
 * @version:
 */
@Service
public class MybatisGeneratorServiceImpl implements MybatisGeneratorService{

    @Autowired
    MybatisGeneratorDOMapper mybatisGeneratorDOMapper;

    /**
     * @Description 新增数据
     * @param mybatisGeneratorDO
     * @return 
     * @date 2019/11/24 14:50
     * @auther Shawn Wu
     */
    @Override
    public String insertMyGenerator(MybatisGeneratorDO mybatisGeneratorDO) {
        if(StringUtils.isEmpty(mybatisGeneratorDO.getId())){
            mybatisGeneratorDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        String nowDate = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        mybatisGeneratorDO.setBatchCreationTime(nowDate);
        mybatisGeneratorDOMapper.insert(mybatisGeneratorDO);
        return mybatisGeneratorDO.getId();
    }

    /**
     * @Description 根据id修改数据
     * @param mybatisGeneratorDO
     * @return 
     * @date 2019/11/24 14:50
     * @auther Shawn Wu
     */
    @Override
    public String updateMyGeneratorById(MybatisGeneratorDO mybatisGeneratorDO) {
        if(StringUtils.isEmpty(mybatisGeneratorDO.getId())){
            throw new CommonException("id不能为空");
        }
        MybatisGeneratorDOExample example = new MybatisGeneratorDOExample();
        MybatisGeneratorDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(mybatisGeneratorDO.getId());
        mybatisGeneratorDOMapper.updateByExampleSelective(mybatisGeneratorDO, example);
        return mybatisGeneratorDO.getId();
    }

    /**
     * @Description 根据id删除数据
     * @param id
     * @return 
     * @date 2019/11/24 15:02
     * @auther Shawn Wu
     */
    @Override
    public String deleteMyGeneratorById(String id) {
        if(StringUtils.isEmpty(id)){
            throw new CommonException("id不能为空");
        }
        mybatisGeneratorDOMapper.deleteByPrimaryKey(id);
        return id;
    }

    /**
     * @Description 查询符合条件的数据
     * @param mybatisGeneratorDO
     * @return 
     * @date 2019/11/24 15:10
     * @auther Shawn Wu
     */
    @Override
    public List<MybatisGeneratorDO> getMyGeneratorByCondition(MybatisGeneratorDO mybatisGeneratorDO) {
        List<MybatisGeneratorDO> mybatisGeneratorDOList = mybatisGeneratorDOMapper.getMyGeneratorByCondition(mybatisGeneratorDO);
        return mybatisGeneratorDOList;
    }
}
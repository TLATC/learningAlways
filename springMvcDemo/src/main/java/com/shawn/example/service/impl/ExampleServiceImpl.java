package com.shawn.example.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shawn.base.exception.CommonException;
import com.shawn.example.dao.ExampleDao;
import com.shawn.example.model.Example;
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
public class ExampleServiceImpl extends ServiceImpl<ExampleDao, Example> implements ExampleService {

    /**
     * 示例方法 hello
     * @return
     */
    @Override
    public String hello() {
        return "Hello World";
    }

    /**
     * 插入示例类
     * @param example 示例类
     * @return
     */
    @Override
    public Integer insertExample(Example example) {
        if(null == example.getExampleId()){
            throw new CommonException("主键id不能为空");
        }
        return baseMapper.insert(example);
    }

    /**
     * 根据id更新示例类
     * @param example 示例类
     * @return
     */
    @Override
    public Integer updateExampleById(Example example) {
        if(null == example.getExampleId()){
            throw new CommonException("主键id不能为空");
        }
        return baseMapper.updateById(example);
    }

    /**
     * 根据id删除示例类
     * @param id 主键id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        if(null == id){
            throw new CommonException("主键id不能为空");
        }
        return baseMapper.deleteById(id);
    }

    /**
     * 根据id查询示例类
     * @param id 主键id
     * @return 示例类
     */
    @Override
    public Example selectById(Integer id) {
        if(null == id){
            throw new CommonException("主键id不能为空");
        }
        return baseMapper.selectById(id);
    }
/*
    @Override
    public List<Example> selectList(Example example) {
        return baseMapper.selectList(new EntityWrapper<User>().eq("name", "张三"));
    }*/
}
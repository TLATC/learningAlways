package com.shawn.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.shawn.example.model.Example;
import org.springframework.stereotype.Service;


/**
 * @ClassName: ExampleService
 * @Description 示例service
 * @author: Shawn Wu
 * @date: 2019/2/1 16:45
 * @version:
 */
public interface ExampleService extends IService<Example>{

    /**
     * 示例方法 hello
     * @return
     */
    String hello();

    /**
     * 插入
     * @param example 示例类
     * @return
     */
    Integer insertExample(Example example);

    /**
     * 根据id更新
     * @param example 示例类
     * @return
     */
    Integer updateExampleById(Example example);

    /**
     * 根据id删除
     * @param id 主键id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * 根据id查询
     * @param id 主键id
     * @return 示例类
     */
    Example selectById(Integer id);

    /**
     * 根据id查询
     * @param example
     * @return 示例类列表
     */
//    List<Example> selectList(Example example);
}

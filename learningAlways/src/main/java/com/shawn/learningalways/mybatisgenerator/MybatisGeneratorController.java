package com.shawn.learningalways.mybatisgenerator;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.mybatisgenerator.model.MybatisGeneratorDO;
import com.shawn.learningalways.mybatisgenerator.service.MybatisGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: MybatisGeneratorController
 * @Description mybatis逆向工程控制层
 * @author: Shawn Wu
 * @date: 2019/11/24 15:11
 * @version:
 */
@RestController
@RequestMapping("myGenerator")
public class MybatisGeneratorController extends BaseController{

    @Autowired
    MybatisGeneratorService mybatisGeneratorService;

    
    /**
     * @Description 新增数据
     * @param mybatisGeneratorDO
     * @return 
     * @date 2019/11/24 15:28
     * @auther Shawn Wu
     */
    @PostMapping("insertMyGenerator")
    public JsonResult insertMyGenerator(@RequestBody MybatisGeneratorDO mybatisGeneratorDO){
        String id = mybatisGeneratorService.insertMyGenerator(mybatisGeneratorDO);
        return renderSuccess(id);
    }

    /**
     * @Description 根据id修改数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 15:28
     * @auther Shawn Wu
     */
    @PostMapping("updateMyGeneratorById")
    public JsonResult updateMyGeneratorById(@RequestBody MybatisGeneratorDO mybatisGeneratorDO){
        String id = mybatisGeneratorService.updateMyGeneratorById(mybatisGeneratorDO);
        return renderSuccess(id);
    }

    /**
     * @Description 根据id删除数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 15:28
     * @auther Shawn Wu
     */
    @PostMapping("deleteMyGeneratorById")
    public JsonResult deleteMyGeneratorById(@RequestBody MybatisGeneratorDO mybatisGeneratorDO){
        String id = mybatisGeneratorService.deleteMyGeneratorById(mybatisGeneratorDO.getId());
        return renderSuccess(id);
    }

    /**
     * @Description 查询符合条件的数据
     * @param mybatisGeneratorDO
     * @return
     * @date 2019/11/24 15:28
     * @auther Shawn Wu
     */
    @PostMapping("getMyGeneratorByCondition")
    public JsonResult getMyGeneratorByCondition(@RequestBody MybatisGeneratorDO mybatisGeneratorDO){
        List<MybatisGeneratorDO> mybatisGeneratorDOList = mybatisGeneratorService.getMyGeneratorByCondition(mybatisGeneratorDO);
        return renderSuccess(mybatisGeneratorDOList);
    }
}
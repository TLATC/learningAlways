package com.shawn.example.controller;

import com.shawn.base.controller.BaseController;
import com.shawn.base.model.JsonResult;
import com.shawn.example.model.Example;
import com.shawn.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ExampleController
 * @Description 示例Controller
 * @author: Shawn Wu
 * @date: 2019/2/1 16:21
 * @version:
 */
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    @Autowired
    ExampleService exampleService;
//    ExampleDao exampleDao;

//    @RequestMapping("/hello")
//    public String hello() {
//        return exampleService.hello();
//    }

    /**
     * 插入示例类
     * @param example
     * @return
     */
    @RequestMapping("/insertExample")
    @ResponseBody
    public JsonResult insertExample(Example example){
        try{
//            exampleDao.insert(example);
            exampleService.insertExample(example);
        }catch (Exception e){
            return renderError(e.getMessage());
        }
        return renderSuccess(example);
    }

    /**
     * 更新示例类
     * @param example
     * @return
     */
    @RequestMapping("/updateExampleById")
    @ResponseBody
    public JsonResult updateExampleById(Example example){
        try{
//            exampleDao.updateById(example);
            exampleService.updateExampleById(example);
        }catch (Exception e){
            return renderError(e.getMessage());
        }
        return renderSuccess(example);
    }

    /**
     * 根据id删除示例类
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public JsonResult deleteById(Integer id){
        try{
            exampleService.deleteById(id);
        }catch (Exception e){
            return renderError(e.getMessage());
        }
        return renderSuccess(id);
    }

    /**
     * 根据id查询示例类
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public JsonResult selectById(Integer id){
        Example example = new Example();
        try{
//            example = exampleDao.selectById(id);
            example = exampleService.selectById(id);
        }catch (Exception e){
            return renderError(e.getMessage());
        }
        return renderSuccess(example);
    }


}
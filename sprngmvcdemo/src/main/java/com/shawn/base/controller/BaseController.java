package com.shawn.base.controller;

import com.shawn.base.model.JsonResult;

/**
 * @ClassName: BaseController
 * @Description 基础控制器
 * @author: Shawn Wu
 * @date: 2019/2/1 16:14
 * @version:
 */
public class BaseController {
    /**
     * 渲染成功数据
     * @return
     */
    protected JsonResult renderSuccess(){
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setStatus("200");
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     * @param msg 需要返回的信息
     * @return
     */
    protected JsonResult renderSuccess(String msg){
        JsonResult result = renderSuccess();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     * @param obj 需要返回的对象
     * @return
     */
    protected JsonResult renderSuccess(Object obj){
        JsonResult result = renderSuccess();
        result.setObj(obj);
        return result;
    }

    /**
     * 渲染失败数据
     * @return
     */
    protected JsonResult renderError(){
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        return result;
    }

    /**
     * 渲染失败数据（带消息）
     * @param msg 需要返回的消息
     * @return
     */
    protected JsonResult renderError(String msg){
        JsonResult result = renderError();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染失败数据（带数据）
     * @param obj 需要返回的对象
     * @return
     */
    protected JsonResult renderError(Object obj) {
        JsonResult result = renderError();
        result.setObj(obj);
        return result;
    }
}
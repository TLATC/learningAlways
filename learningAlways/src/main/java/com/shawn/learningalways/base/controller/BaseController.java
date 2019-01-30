package com.shawn.learningalways.base.controller;

import com.shawn.learningalways.base.model.JsonResult;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: BaseController
 * 软件版权: Jones
 * 功能说明：基础控制器
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/1 15:48
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
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

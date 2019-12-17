package com.shawn.learningalways.base.model;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: JsonResult
 * 软件版权: shawn
 * 功能说明：统一的JSON返回对象
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/7/1 15:44
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class JsonResult {

    /**
     * 是否正确返回
     */
    private boolean success;
    /**
     * 状态码
     */
    private String status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回对象
     */
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}

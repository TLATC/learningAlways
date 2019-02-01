package com.shawn.base.model;

/**
 * @ClassName: JsonResult
 * @Description 统一的JSON返回对象
 * @author: Shawn Wu
 * @date: 2019/2/1 16:17
 * @version:
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
}
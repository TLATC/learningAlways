package com.jones.myspringboot.base.exception;

/**
 * 系统名称: U-OBS-ROBOT
 * 模块名称:
 * 类 名 称: CommonException
 * 软件版权: 远传股份有限公司
 * 功能说明：自定义异常
 * 系统版本： 5.0.1
 * 开发人员:  wuxh
 * 开发时间: 2018/7/2 18:19
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -1340328704145759576L;

    /**
     * 错误Code
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 重载构造函数
     * @param msg
     */
    public CommonException(String msg){
        super(msg);
        this.errorMsg = msg;
    }

    public CommonException(Exception e){
        super(e);
        this.errorMsg = e.getMessage();
    }

    public CommonException(String code, String msg){
        super(msg);
        this.errorMsg = msg;
        this.errorCode = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
package com.shawn.base.exception;

/**
 * @ClassName: CommonException
 * @Description 自定义异常
 * @author: Shawn Wu
 * @date: 2019/2/1 16:19
 * @version:
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
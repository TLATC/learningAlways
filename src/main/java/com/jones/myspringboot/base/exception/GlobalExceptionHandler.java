package com.jones.myspringboot.base.exception;

import com.jones.myspringboot.base.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: GlobalExceptionHandler
 * 软件版权: Jones
 * 功能说明：全局异常处理类
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/1 16:37
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 统一异常处理
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult CommonExceptionHandler(HttpServletRequest req, Exception e){

        //此处要加后台日志打印。否则拦截后，后台日志不会打印
        LOGGER.error("处理普通请求异常时响应到客户端异常",e);
        LOGGER.debug("这是debug级别日志"); //todo:日志级别修改并未生效
        LOGGER.info("这是info级别的日志");

        String errorMsg = e.getMessage();
        if(e instanceof CommonException){
            errorMsg = errorMsg;
        } else if(e instanceof ClassNotFoundException){
            errorMsg = "未找到需要的类";
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            errorMsg = "数组下标越界异常";
        } else if (e instanceof ClassCastException) {
            errorMsg = "类型强制转换异常";
        } else if (e instanceof NullPointerException) {
            errorMsg = "空指针异常";
        } else if (e instanceof NumberFormatException) {
            errorMsg = "字符串格式转换异常";
        } else if (e instanceof NestedRuntimeException) {
            errorMsg = "数据库执行异常";
        }else {
            errorMsg = "请求异常,请联系管理员";
        }

        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        result.setMsg(errorMsg);
        return  result;
    }

}

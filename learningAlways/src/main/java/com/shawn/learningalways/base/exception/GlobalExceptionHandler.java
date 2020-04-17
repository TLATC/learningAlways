package com.shawn.learningalways.base.exception;

import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: GlobalExceptionHandler
 * 软件版权: shawn
 * 功能说明：全局异常处理类
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/7/1 16:37
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseRender {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 统一异常处理
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult commonExceptionHandler(HttpServletRequest req, Exception e){

        // 此处要加后台日志打印。否则拦截后，后台日志不会打印
        LOGGER.error("处理普通请求异常时响应到客户端异常",e);

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

    /**
     * 方法参数校验异常处理
     *
     * @param e 方法参数校验异常
     * @return 结果
     * @date 2020/4/16 14:51
     * @author Shawn Wu
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error("参数校验异常：" + e.getMessage());
        return renderError(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 校验异常处理
     *
     * @param e 校验异常
     * @return 结果
     * @date 2020/4/16 15:57
     * @author Shawn Wu
     */
    @ExceptionHandler(ValidationException.class)
    public JsonResult handleValidationException(ValidationException e){
        LOGGER.error(e.getMessage(), e);
        return renderError(e.getCause().getMessage());
    }

    /**
     * todo: 此处应该有方法描述
     *
     * @param e
     * @return
     * @date 2020/4/16 16:01
     * @author Shawn Wu
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult handleConstraintViolationException(ConstraintViolationException e){
        LOGGER.error(e.getMessage(), e);
        return renderError(e.getMessage());
    }

    /**
     * 数据重复异常处理
     *
     * @param e 数据重复异常
     * @return 结果
     * @date 2020/4/16 16:04
     * @author Shawn Wu
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public JsonResult handleDuplicateKeyException(DuplicateKeyException e){
        LOGGER.error(e.getMessage(), e);
        return renderError("数据重复，请检查后提交");
    }


}

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

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * GlobalExceptionHandler
 * 全局异常处理类
 *
 * @author Shawn Wu
 * @date 2018/7/1 16:37
 * @since x
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseRender {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * Exception处理
     *
     * @param e Exception
     * @return 异常结果
     * @date 2020/5/8 14:35
     * @author Shawn Wu
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(Exception e, HttpServletRequest request){
        LOGGER.error("处理普通请求异常时响应到客户端异常，请求接口为{}", request.getRequestURI(), e);
        return renderError(e.getMessage());
    }

    /**
     * 本项目的自定义异常CommonException处理
     *
     * @param e CommonException
     * @return 异常结果
     * @date 2020/5/8 14:36
     * @author Shawn Wu
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public JsonResult handleCommonException(CommonException e, HttpServletRequest request){
        LOGGER.error("处理普通请求异常时响应到客户端异常，请求接口为{}", request.getRequestURI(), e);
        return renderError(e.getMessage());
    }

    /**
     * NestedRuntimeException异常处理
     *
     * @param e NestedRuntimeException
     * @return 异常结果
     * @date 2020/5/8 14:37
     * @author Shawn Wu
     */
    @ExceptionHandler(NestedRuntimeException.class)
    @ResponseBody
    public JsonResult handleNullPointerException(NestedRuntimeException e, HttpServletRequest request){
        LOGGER.error("数据库执行异常，请求接口为{}", request.getRequestURI(), e);
        return renderError("数据库执行异常");
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
     * 校验异常
     *
     * @param e 校验异常
     * @return 结果
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

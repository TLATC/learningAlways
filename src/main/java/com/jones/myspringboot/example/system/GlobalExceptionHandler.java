package com.jones.myspringboot.example.system;

import com.jones.myspringboot.base.model.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: GlobalExceptionHandler
 * 软件版权: Jones
 * 功能说明：全局异常处理类 todo:考虑采用
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/1 16:37
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理MyException类型的异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public JsonResult jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        result.setMsg(e.getMessage());
        return  result;
    }
}

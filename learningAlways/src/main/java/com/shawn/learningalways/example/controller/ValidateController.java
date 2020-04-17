package com.shawn.learningalways.example.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.example.model.ValidateUserDTO;
import com.shawn.learningalways.example.service.ValidateCreate;
import com.shawn.learningalways.example.service.ValidateService;
import com.shawn.learningalways.example.service.ValidateUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ValidateController
 * 测试用注解参数校验
 *
 * @author Shawn Wu
 * @date 2020/4/16 14:04
 * @since x
 */
@RestController
public class ValidateController extends BaseRender {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateController.class);

    @Autowired
    private ValidateService validateService;

    /**
     * 保存用户信息
     *
     * @param userDTO 用户信息
     * @return 保存结果
     * @date 2020/4/16 14:36
     * @author Shawn Wu
     */
    @PostMapping("/save/valid")
    @ResponseBody
    public JsonResult save(@RequestBody @Validated(ValidateCreate.class) ValidateUserDTO userDTO){
        validateService.save(userDTO);
        return renderSuccess();
    }

    /**
     * 修改用户信息
     *
     * @param userDTO 用户信息
     * @return 修改结果
     * @date 2020/4/17 17:25
     * @author Shawn Wu
     */
    @PostMapping("/update/valid")
    @ResponseBody
    public JsonResult update(@RequestBody @Validated(ValidateUpdate.class) ValidateUserDTO userDTO){
        validateService.update(userDTO);
        return renderSuccess();
    }
}
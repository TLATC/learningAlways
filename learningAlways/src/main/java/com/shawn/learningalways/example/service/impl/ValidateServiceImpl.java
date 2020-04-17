package com.shawn.learningalways.example.service.impl;

import com.shawn.learningalways.example.controller.ValidateController;
import com.shawn.learningalways.example.model.ValidateUserDTO;
import com.shawn.learningalways.example.service.ValidateCreate;
import com.shawn.learningalways.example.service.ValidateService;
import com.shawn.learningalways.example.service.ValidateUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ValidateServiceImpl
 * 校验的服务层
 *
 * @author Shawn Wu
 * @date 2020/4/17 17:56
 * @since x
 */
@Service
public class ValidateServiceImpl implements ValidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateController.class);


    /**
     * 新增
     *
     * @param validateUserDTO 校验用户
     * @date 2020/4/17 17:58
     * @author Shawn Wu
     */
    @Override
    public void save(ValidateUserDTO validateUserDTO) {
        LOGGER.debug("新增方法---用户姓名是：{}", validateUserDTO.getUserName());
    }

    /**
     * 修改
     *
     * @param validateUserDTO 校验用户
     * @date 2020/4/17 17:59
     * @author Shawn Wu
     */
    @Override
    public void update(ValidateUserDTO validateUserDTO) {
        LOGGER.debug("修改方法---用户姓名是：{}", validateUserDTO.getUserName());
    }
}
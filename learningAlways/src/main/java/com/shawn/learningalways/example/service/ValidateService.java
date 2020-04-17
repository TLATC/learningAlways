package com.shawn.learningalways.example.service;

import com.shawn.learningalways.example.model.ValidateUserDTO;
import org.springframework.validation.annotation.Validated;

/**
 * ValidateService
 * 校验接口
 *
 * @author Shawn Wu
 * @date 2020/4/17 17:47
 * @since x
 */
public interface ValidateService {

    /**
     * 新增
     *
     * @param validateUserDTO 校验用户实体
     * @date 2020/4/17 17:54
     * @author Shawn Wu
     */
    void save(ValidateUserDTO validateUserDTO);

    /**
     * 修改
     *
     * @param validateUserDTO 校验用户实体
     * @date 2020/4/17 17:56
     * @author Shawn Wu
     */
    void update(ValidateUserDTO validateUserDTO);
}

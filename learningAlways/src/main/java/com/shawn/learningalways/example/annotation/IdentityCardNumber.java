package com.shawn.learningalways.example.annotation;

import com.shawn.learningalways.example.aspect.IdentityCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * IdentityCardNumber
 * 身份证号验证的自定义注解
 *
 * @author Shawn Wu
 * @date 2020/4/17 16:25
 * @since x
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {

    /**
     * 验证失败提醒内容
     */
    String message() default "身份证号码不合法";

    /**
     * 不同的类group中执行不同的校验规则
     */
    Class<?>[] groups() default {};

    /**
     * 主要针对bean
     */
    Class<? extends Payload>[] payload() default {};
}

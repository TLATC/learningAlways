package com.shawn.learningalways.example.aspect;

import com.shawn.learningalways.example.annotation.IdentityCardNumber;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * IdentityCardNumberValidator
 * 身份证号码的验证逻辑
 *
 * @author Shawn Wu
 * @date 2020/4/17 16:37
 * @since x
 */
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object>{

    @Override
    public void initialize(IdentityCardNumber identityCardNumber) {

    }

    /**
     * 是否校验成功，true为校验通过，false为校验失败
     *
     * @param param 参数
     * @param constraintValidatorContext ConstraintValidatorContext
     * @return 校验结果
     * @date 2020/4/17 17:00
     * @author Shawn Wu
     */
    @Override
    public boolean isValid(Object param, ConstraintValidatorContext constraintValidatorContext) {
        String cardNum = param.toString();
        if(StringUtils.isEmpty(cardNum)){
            return false;
        }
        // 自定义的身份证校验规则
        return cardNum.length()>10;
    }
}
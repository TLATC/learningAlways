package com.shawn.learningalways.example.model;

import com.shawn.learningalways.example.annotation.IdentityCardNumber;
import com.shawn.learningalways.example.service.ValidateCreate;
import com.shawn.learningalways.example.service.ValidateUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * ValidateUserDTO
 * 用词参数校验的dto
 *
 * @author Shawn Wu
 * @date 2020/4/16 14:08
 * @since x
 */
@Data
public class ValidateUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空", groups = ValidateUpdate.class)
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符", groups = {ValidateUpdate.class, ValidateCreate.class})
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String userName;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3456789][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    @IdentityCardNumber(message = "身份证信息有无，请核对后提交")
    private String clientCardNo;

//    /**
//     * 创建时间
//     */
//    @Future(message = "时间必须是将来时间")
//    private Date createTime;

}
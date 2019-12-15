package com.shawn.learningalways.login.model;

import com.shawn.learningalways.base.model.BaseBean;

/**
 * @ClassName: Customer
 * @Description 客户
 * @author: Shawn Wu
 * @date: 2019/12/12 19:44
 * @version:
 */
public class Customer extends BaseBean{

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 客户号
     */
    private String customerNO;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户年龄
     */
    private Integer age;

    /**
     * 客户等级（由0到10递增）
     */
    private Integer customerLevel;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNO() {
        return customerNO;
    }

    public void setCustomerNO(String customerNO) {
        this.customerNO = customerNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }
}
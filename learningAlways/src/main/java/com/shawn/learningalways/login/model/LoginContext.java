package com.shawn.learningalways.login.model;

/**
 * @ClassName: LoginContext
 * @Description 登录上下文信息
 * @author: Shawn Wu
 * @date: 2019/12/12 19:38
 * @version:
 */
public class LoginContext {

    /**
     * 职员类
     */
    private Staff staff;

    /**
     * 客户类
     */
    private Customer customer;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
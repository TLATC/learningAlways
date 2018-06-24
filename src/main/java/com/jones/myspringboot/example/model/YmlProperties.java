package com.jones.myspringboot.example.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统名称: mySpringBoot
 * 模块名称: 测试模块
 * 类 名 称: YmlProperties
 * 软件版权: Jones
 * 功能说明：测试读取配置文件
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/24 15:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

@Component
public class YmlProperties {

    /**
     * 通用配置文件中的spring.profiles.active
     */
    @Value("${spring.profiles.active}")
    private String active;
    /**
     * 直接赋值
     */
    @Value("{我是直接赋值的}")
    private String text;
    /**
     * dev配置文件中的desc
     */
    @Value("${com.jones.myspringboot.desc}")
    private String desc;
    /**
     * dev配置文件中的server.port
     */
    private static String port; //静态属性取值方式不同，需用set方法

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPort() {
        return port;
    }

    @Value("${server.port}")
    public void setPort(String port) { //set方法不能是静态的，否则取不到值
        YmlProperties.port = port;
    }
}

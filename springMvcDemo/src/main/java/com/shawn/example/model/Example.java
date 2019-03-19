package com.shawn.example.model;

import com.baomidou.mybatisplus.annotations.TableName;
import com.shawn.base.model.BaseBean;

import java.math.BigInteger;

/**
 * @ClassName: Example
 * @Description 示例实体类
 * @author: Shawn Wu
 * @date: 2019/2/13 14:24
 * @version:
 */
@TableName(value = "t_shawn_example")
public class Example extends BaseBean{

    /**
     * 主键id
     */
    private BigInteger exampleId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别（0为女，1为男）
     */
    private Integer gender;

    public BigInteger getExampleId() {
        return exampleId;
    }

    public void setExampleId(BigInteger exampleId) {
        this.exampleId = exampleId;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Example{" +
                "exampleId=" + exampleId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
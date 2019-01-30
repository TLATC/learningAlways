package com.shawn.learningalways.set.model;

/**
 * @ClassName: StudentNoHash
 * @Description 没有重写hashCode的学生类
 * @author: Shawn Wu
 * @date: 2018/12/11 15:03
 * @version:
 */
public class StudentNoHash {

    /**
     * 唯一id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public StudentNoHash(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentNoHash{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
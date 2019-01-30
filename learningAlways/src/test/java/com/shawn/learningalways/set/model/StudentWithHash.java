package com.shawn.learningalways.set.model;

/**
 * @ClassName: StudentWithHash
 * @Description： 重写了hash方法的学生类
 * @author: Shawn Wu
 * @date: 2018/12/11 14:39
 * @version:
 */
public class StudentWithHash {

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

    public StudentWithHash(String id, String name, int age) {
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
        return "StudentWithHash{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 重写equals方法
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        // 提高效率
        if (this == o){
            return true;
        }
        // 提高代码健壮性,不是同一个类型就直接返回false,省得向下转型了
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        // 向下转型
        StudentWithHash that = (StudentWithHash) o;

        // 判断age、id、name是否相等
        if (age != that.age){
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null){
            return false;
        }
        return name != null ? name.equals(that.name) : that.name == null;
    }

    /**
     * 重写hashCode方法
     * 根据id、name、age为参数计算hash值
     * 取31为权是因为31*i=32*i-i=(i<<5)-i，这种位移与减法结合的计算相比一般的运算快很多
     * @return
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
package com.jones.learningalways.set;

import com.jones.learningalways.set.model.StudentNoHash;
import com.jones.learningalways.set.model.StudentWithHash;

import java.util.HashSet;

/**
 * @ClassName: HashSetDemo
 * @Description hashSet的demo类
 * @author: Shawn Wu
 * @date: 2018/12/11 15:01
 * @version:
 */
public class HashSetDemo {

    /*
     * Set下的HashSet集合通过集合元素的hashCode()方法和equals()方法来进行去重复，
     * 如果两个元素的hashCode相等，然后再去调用equals方法,
     * 如果也相等，那么就认为这两个元素相等，第二个元素就不会添加到集合中，从而保证了元素的去重复；
     */

    /**
     * 测试hashSet里面添加对象去重
     * 被添加对象不重写hashCode
     */
    private static void noRewriteSetAddTest(){
        // 新建学生对象，其中s1和s3值完全一致
        StudentNoHash s1 = new StudentNoHash("1","张三",10);
        StudentNoHash s2 = new StudentNoHash("2","李四",20);
        StudentNoHash s3 = new StudentNoHash("1","张三",10);

        /*
         * 对象的hashCode默认是根据内部地址转换而成的
         * 添加学生对象到集合中,s1与s3的地址不一样，hash值不一样，不会重复
         */
        HashSet<StudentNoHash> hs = new HashSet<StudentNoHash>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println("不重写hashCode，测试hashSet的add:");
        for(StudentNoHash studentNoHash: hs){
            System.out.println(studentNoHash);
        }
    }

    /**
     * 测试hashSet里面添加对象去重
     * 被添加对象不重写hashCode
     */
    private static void rewriteSetAddTest(){
        // 新建学生对象，其中s1和s3值完全一致
        StudentWithHash s1 = new StudentWithHash("1","张三",10);
        StudentWithHash s2 = new StudentWithHash("2","李四",20);
        StudentWithHash s3 = new StudentWithHash("1","张三",10);

        /*
         * 由于重写了hashCode，s3会和s1重复，会被set去重
         */
        HashSet<StudentWithHash> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println("重写hashCode，测试hashSet的add:");
        for(StudentWithHash studentWithHash: hs){
            System.out.println(studentWithHash);
        }
    }

    public static void main(String[] args) {
        noRewriteSetAddTest();
        System.out.println();
        rewriteSetAddTest();
    }
}
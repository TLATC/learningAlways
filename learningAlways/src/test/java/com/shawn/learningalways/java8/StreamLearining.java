package com.shawn.learningalways.java8;

import com.shawn.learningalways.hrm.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: StreamLearining
 * @Description java8的Stream流学习
 * @author: Shawn Wu
 * @date: 2019/12/8 15:14
 * @version:
 */
public class StreamLearining {

    @Test
    public void test1(){
        Stream<Integer> stream1 = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        // filter接受一个Lambda表达式作为参数
        Stream<Integer> newStream = stream1.filter(s -> s>5).distinct().skip(2).limit(3);
        newStream.forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        // map接收一个function表达式，有返回值
        // 将每个元素转成一个新的不带逗号的元素
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println);

        Stream<String> s3 = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println);
    }


    @Test
    public void test3(){
        // String类自身已实现Compareable接口
        List<String> list = Arrays.asList("aa", "ff", "dd");
        list.stream().sorted().forEach(System.out::println);

        // 自定义排序：先按姓名升序，姓名相同则按年龄升序
        User user1 = new User("user1", "10", "男");
        User user2 = new User("user1", "15", "女");
        User user3 = new User("user3", "20", "男");
        List<User> userList = Arrays.asList(user1, user2, user3);
        userList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getUserName().equals(o2.getUserName())){
                        return o1.getAge().compareTo(o2.getAge());
                    }else{
                        return o1.getAge().compareTo(o2.getAge());
                    }
                }
        ).forEach(System.out::println);
    }

    @Test
    public void test4(){
        User user1 = new User("user1", "10", "男");
        User user2 = new User("user2", "15", "女");
        List<User> userList = Arrays.asList(user1, user2);
        // peek接收的是Consumer表达式，没有返回值
        userList.stream().peek(o -> o.setAge("40")).forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        boolean allMatch = list.stream().allMatch(o -> o>3);
        boolean noneMatch = list.stream().noneMatch(o -> o>3);
        boolean anyMatch = list.stream().anyMatch(o -> o>3);

        Integer first = list.stream().findFirst().get();
        Integer any = list.stream().findAny().get();

        long count = list.stream().count();
        Integer max = list.stream().max(Integer::compareTo).get();
        Integer min = list.stream().min(Integer::compareTo).get();
    }

    @Test
    public void test6(){
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        // 串行流
        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println("数组的总和为：" + v);
        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println("数组的总和加10为：" + v1);

        // 并行流，会启多个线程
        Integer v2 = list.parallelStream().reduce(0,
                (x1, x2) -> {
                    return x1 - x2;
                },
                (x1, x2) -> {
                    return x1 * x2;
                }
        );
        System.out.println(v2);
    }


    @Test
    public void test7(){
        User user1 = new User("user1", "10", "男");
        User user2 = new User("user2", "15", "女");
        User user3 = new User("user3", "20", "男");
        List<User> userList = Arrays.asList(user1, user2, user3);

        List<String> ageList = userList.stream().map(o -> o.getAge()).collect(Collectors.toList());
        Set<String> ageSet = userList.stream().map(o -> o.getAge()).collect(Collectors.toSet());
        // 转成map,注:key不能相同，否则报错
        Map<String, String> userMap = userList.stream().collect(Collectors.toMap(User::getUserName, User::getAge));


        /*
         * 聚合操作
         */
        Long count = userList.stream().collect(Collectors.counting());

        // 分组
        Map<String, List<User>> ageMap = userList.stream().collect(Collectors.groupingBy(User::getSex));

        // 分区。分成两部分，一部分等于10岁，一部分不等于10岁
        Map<Boolean, List<User>> partMap = userList.stream().collect(Collectors.partitioningBy(o -> o.getAge().equals("10")));

    }
}
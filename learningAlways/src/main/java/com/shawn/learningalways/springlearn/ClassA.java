package com.shawn.learningalways.springlearn;

import lombok.Data;

/**
 * ClassA
 * 配合CircularDependency类模拟循环依赖
 *
 * @author Shawn Wu
 * @date 2020/5/25 16:29
 * @since x
 */
@Data
public class ClassA {

    /**
     * 模拟spring的@Autowired，依赖ClassB
     */
    private ClassB b;
}
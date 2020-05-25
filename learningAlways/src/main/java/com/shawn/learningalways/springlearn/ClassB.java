package com.shawn.learningalways.springlearn;

import lombok.Data;

/**
 * ClassB
 * 配合CircularDependency类模拟循环依赖
 *
 * @author Shawn Wu
 * @date 2020/5/25 16:29
 * @since
 */
@Data
public class ClassB {

    /**
     * 模拟spring的@Autowired，依赖ClassA
     */
    private ClassA a;
}
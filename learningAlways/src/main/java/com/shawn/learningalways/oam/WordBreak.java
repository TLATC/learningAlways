package com.shawn.learningalways.oam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * WordBreak
 * 题目：判断字符串是否能分割成字典中的单词
 *
 * 比如：词典是{"apple", "orange", "pie"},
 * applepie 可以划分为 apple/pie；
 * applepieapple 可以划分为 apple/pie/apple,
 * 但是“appie”就无法划分。
 *
 * @author Shawn Wu
 * @date 2020/4/18 16:29
 * @since x
 */
public class WordBreak {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordBreak.class);

    /**
     * 判断字符串是否可以被划分为字典中的值
     *
     * 思路：
     * 遍历字符串每个位置i，判断i之前的子字符串（即context[0,i]），是否可以被划分为字典中的值，
     * 如果可以，则将位置i标识为true，否则为fasle，记为canDivide[i]
     * 根据最后一位上的标记，即可判断整个字符串是否可被划分。
     *
     * 判断i之前的子字符串（即context[0,i]）是否可被划分的方法为：
     * 0-i之间，一定存在一点j，使得context[0,j]可被分隔，且context[j,i]在字典中
     *
     * @param dictionary 字符串字典
     * @param context 要判断的字符串
     * @return true为可以，false为不行
     * @date 2020/4/18 16:34
     * @author Shawn Wu
     */
    private static boolean canDivideAble(Set<String> dictionary, String context){
        // 两者任意一方为空，就false
        if(dictionary.isEmpty() || StringUtils.isEmpty(context)){
            return false;
        }
        // 如果被字典包含，则true
        if (dictionary.contains(context)) {
            return true;
        }

        // canDivide[i]记录到当前下标为止的子字符串，能否被分隔成字典中的值
        boolean[] canDivide = new boolean[context.length()+1];
        // 起始位默认可以
        canDivide[0] = true;

        for(int i=1; i<=context.length(); i++) {
            boolean flag = false;
            for(int j=0; j<i; j++) {
                // j之前的位置可以被分隔，且context[j,i]在字典中，则canDivide[i]为true
                if(canDivide[j] && dictionary.contains(context.substring(j, i))) {
                    flag = true;
                    break;
                }
            }
            canDivide[i] = flag;
        }

        return canDivide[context.length()];
    }

    /**
     * 主方法
     *
     * @param args 参数
     * @date 2020/4/18 12:02
     * @author Shawn Wu
     */
    public static void main(String[] args) {
        // 构造字典
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("orange");
        dictionary.add("pie");
        // 要判断的字符串
        String context = "applepieorange33";
        // 判断结果
        boolean result = canDivideAble(dictionary, context);
        LOGGER.debug("判断结果为：{}", result);
    }

}

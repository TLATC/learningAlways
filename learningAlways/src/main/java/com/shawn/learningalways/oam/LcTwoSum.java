package com.shawn.learningalways.oam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * LcTwoSum
 * LeetCode第一题：求两数之和
 *
 * 比如：给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 注：你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * @author Shawn Wu
 * @date 2020/5/25 13:44
 * @since
 */
public class LcTwoSum {

    private static final Logger LOGGER = LoggerFactory.getLogger(LcTwoSum.class);

    
    /**
     * 判断数组中是否存在两个数字，他们的和为target
     *
     * @param nums 原始数据数组
     * @param target 目标和
     * @return 如果满足条件，返回两个数再nums数组中的下标
     * @date 2020/5/25 14:08
     * @author Shawn Wu
     */
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }
        /*
         * cacheMap用以保存数组中，已经遍历过的元素
         * 其中，key为nums数组的值，value为nums数组元素对应下标
         */
        Map<Integer, Integer> cacheMap = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            // 若要得到和为target，则需要在cacheMap中找到值anotherNum
            Integer anotherNum = target - nums[i];
            if(cacheMap.containsKey(anotherNum)){
                int[] result = new int[2];
                // 保证下标小的数组在前
                if(i < cacheMap.get(anotherNum)){
                    result[0] = i;
                    result[1] = cacheMap.get(anotherNum);
                }else{
                    result[0] = cacheMap.get(anotherNum);
                    result[1] = i;
                }
                return result;
            }
            // 若暂时找不到，则将当前数据存入cacheMap中
            cacheMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 13};
        int target = 9;
        int[] result = twoSum(nums, target);
        if(result != null && result.length == 2){
            LOGGER.info("数组下标{}和{}的数字，相加可以得到{}", result[0], result[1], target);
            LOGGER.info("即{} + {} = {}", nums[result[0]], nums[result[1]], target);
        }else{
            LOGGER.info("未找到满足条件的两个数，使他们的和为{}", target);
        }
    }
}
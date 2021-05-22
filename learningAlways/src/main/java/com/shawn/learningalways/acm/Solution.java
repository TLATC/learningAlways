package com.shawn.learningalways.acm;


import java.math.BigInteger;
import java.util.*;

/**
 * Solution
 * 刷题临时使用
 *
 * @author Shawn Wu
 * @date 2020/10/15 21:18
 * @since x
 */
public class Solution {

    public static int nthUglyNumber(int n) {
        int ans = 1;
        while(n>0){
            if(ans==1){
                n--;
                ans++;
                continue;
            }
            if(ans%7==0 || ans%11==0 || ans%13==0){
                ans++;
                continue;
            }
            int num = ans;
            while(num%2==0){
                num/=2;
            }
            while(num%3==0){
                num/=3;
            }
            while(num%5==0){
                num/=5;
            }
            if(num==1){
                n--;
            }
            ans++;
        }
        return ans-1;
    }

    public static void main(String[] args) {
        System.out.println(1==nthUglyNumber(1));
        System.out.println(2==nthUglyNumber(2));
        System.out.println(3==nthUglyNumber(3));
        System.out.println(4==nthUglyNumber(4));
        System.out.println(5==nthUglyNumber(5));
        System.out.println(6==nthUglyNumber(6));
        System.out.println(8==nthUglyNumber(7));
        System.out.println(9==nthUglyNumber(8));
        System.out.println(10==nthUglyNumber(9));


    }
}

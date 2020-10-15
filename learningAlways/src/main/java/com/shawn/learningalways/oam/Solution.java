package com.shawn.learningalways.oam;


import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * 刷题临时使用
 *
 * @author Shawn Wu
 * @date 2020/10/15 21:18
 * @since x
 */
public class Solution {

    public static void setZeroes(int[][] matrix) {
        // 行数
        int rowNum = matrix.length;
        if(rowNum == 0){
            return;
        }
        // 列数
        int colNum = matrix[0].length;

        /*
         * 获取需要清零的行列坐标
         */
        List<Integer> indexOfRow = new ArrayList<>(rowNum);
        List<Integer> indexOfCol = new ArrayList<>(colNum);
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(matrix[i][j] == 0){
                    indexOfRow.add(i);
                    indexOfCol.add(j);
                }
            }
        }

        /*
         * 清零
         */
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(indexOfRow.contains(i) || indexOfCol.contains(j)){
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,1,0,1},{1,1,0,1}};
        setZeroes(matrix);
    }
}

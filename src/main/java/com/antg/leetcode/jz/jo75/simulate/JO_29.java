package com.antg.leetcode.jz.jo75.simulate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* @author:Antg
* @create: 2023/9/12
* @Description:
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_29 {
    public static void main(String[] args) {
        int[][] matirx = {
                {1,2,3,4}
                ,{5,6,7,8}
                ,{9,10,11,12}
        };
        int[] res = new JO_29().spiralOrder(matirx);
        Arrays.stream(res).forEach(System.out::println);


    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return new int[0];
        // 定义方向
        int direction=0; // 0向右,1向下,2向左,3向上
        // 定义扫描坐标
        int x=0,y=0;
        // 初始化边界
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        // 结果
        int res[]=new int[matrix.length*matrix[0].length];
        res[0]=matrix[0][0];
        for (int i = 1; i < res.length; i++) {
            // 判断当前位置是否是边界
            if(x==top && y==right && direction==0){
                // 右上角 改变方向 向下
                direction=1;
                // 缩小边界
                top++;
            } else if (x==bottom && y==right && direction==1) {
                // 右下角 改变方向 向左
                direction=2;
                // 缩小边界
                right--;
            } else if (x==bottom && y==left && direction==2) {
                // 左下角 改变方向 向上
                direction=3;
                // 缩小边界
                bottom--;
            } else if (x==top && y==left && direction==3) {
                // 左上角 改变方向 向右
                direction=0;
                // 缩小边界
                left++;

            }
            // 判断移动方向
            switch (direction){
                case 0:
                    // 向右
                    y++;
                    break;
                case 1:
                    // 向下
                    x++;
                    break;
                case 2:
                    // 向左
                    y--;
                    break;
                case 3:
                    // 向上
                    x--;
                    break;
            }
            res[i]=matrix[x][y];
        }

        return res;
        
    }
}

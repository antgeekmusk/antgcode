package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/21
* @Description:
 * LCR 121. 寻找目标值 - 二维数组
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_121 {
    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description: 暴力
    */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[i].length; j++) {
                if(plants[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description: 二叉搜索树
    */
    public boolean findTargetIn2DPlants2(int[][] plants, int target) {
        int i=plants.length-1,j=0;
        while (i>=0 && j<plants[i].length){
            if(plants[i][j]>target){
                i--;
            } else if (plants[i][j]<target) {
                j++;
            }  else{
               return true;
            }
        }
        return false;
    }
}

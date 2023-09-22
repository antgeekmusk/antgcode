package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/21
* @Description:
 * LCR 128. 库存管理 I
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_128 {
    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description: 暴力
    */
    public int stockManagement(int[] stock) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < stock.length; i++) {
            if(stock[i]<min){
                min=stock[i];
            }
        }
        return min;
    }
    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description:
    */
    public int stockManagement2(int[] stock) {
        int low=0,high=stock.length-1;
        while (low<high){
            int mid=(low+high)/2;
            if(stock[mid]<stock[high]){
                high=mid;
            } else if (stock[mid]>stock[high]) {
                low=mid+1;
            }else{
                high-=1;
            }
        }
        return stock[low];
    }
}

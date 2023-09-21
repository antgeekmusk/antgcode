package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/21
* @Description:
 * LCR 173. 点名
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_173 {
    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description: 暴力
    */
    public int takeAttendance(int[] record) {
        int i=0;
        for (; i < record.length; i++) {
            if(record[i]!=i){
                return i;
            }
        }
        if(i==record.length){
            return record.length;
        }
        return -1;
    }
    /**
    * @author:Antg
    * @create: 2023/9/21
    * @Description:
     * 二分法
    */
    public int takeAttendance2(int[] record) {
        int n = record.length;
        if(record[n -1]== n -1) return n;
        int low=0,high=n-1;

        int mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if(record[mid]==mid){
                low=mid+1;
            }else if(record[mid]>mid){
                high=high-1;
            }
        }
        return mid;
    }
}

package com.antg.leetcode.jz.jo75.sort;

import java.util.HashMap;

/**
 * <p>
 *  LCR 186. 文物朝代判断
 *  https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
 * </p>
 * @author Antg
 * @since  2023/9/27 21:05
 **/
public class JO_186 {
    public static void main(String[] args) {
        int[] place = {0, 6, 9, 0, 7};
        System.out.println(new JO_186().checkDynasty(place));
    }
    /**
     * <p>
     *  并且除了0不能有其他重复的
     *  公式 max(place[i])-min(place[j])+1<=place.length ? true : false
     * </p>
     * @author Antg
     * @since  2023/9/27 21:08
     **/
    public boolean checkDynasty(int[] place) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i : place) {
            if(!map.containsKey(i)){
                map.put(i,1);
            } else if (map.containsKey(i) && i!=0) {
                return false;
            }
            if(i>max){
                max=i;
            }
            if(i<min && i!=0){
                min=i;
            }
        }
        return max-min+1<=place.length;
    }
}

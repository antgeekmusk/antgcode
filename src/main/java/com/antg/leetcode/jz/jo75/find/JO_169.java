package com.antg.leetcode.jz.jo75.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @author:Antg
* @create: 2023/9/22
* @Description:
 * LCR 169. 招式拆解 II
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_169 {
    public static void main(String[] args) {
        System.out.println('a'-97);
    }
    /**
    * @author:Antg
    * @create: 2023/9/22
    * @Description: 暴力
    */
    public char dismantlingAction(String list) {
        char res=' ';
        char[] charArray = list.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : charArray) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if(map.get(charArray[i])==1){
                return charArray[i];
            }
        }
        return res;
    }
    /**
    * @author:Antg
    * @create: 2023/9/22
    * @Description:
     * 优化
     * 有序哈希表 LinkedHashMap
    */
    public char dismantlingAction2(String list) {
        char res=' ';
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] charArray = list.toCharArray();
        for (char c : charArray) {
            map.put(c,!map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> ele : map.entrySet()) {
            if(ele.getValue()) return ele.getKey();
        }

        return res;
    }

    /**
    * @author:Antg
    * @create: 2023/9/23
    * @Description:
     * indexOf 和 lastIndexOf
    */
    public char dismantlingAction3(String list) {
        for (char c : list.toCharArray()) {
            if(list.indexOf(c)==list.lastIndexOf(c)) return c;
        }
        return ' ';
    }

    /**
    * @author:Antg
    * @create: 2023/9/23
    * @Description:
     * 使用数组代替哈希表
    */
    public char dismantlingAction4(String list) {
        char[] charArray = list.toCharArray();
        int[] cnt=new int[256];
        for (char c : charArray) {
            int i = c - 0;
            cnt[i]++;
        }
        for (char c : charArray) {
            int i = c - 0;
            if(cnt[i]==1) return c;
        }
        return ' ';

    }


}

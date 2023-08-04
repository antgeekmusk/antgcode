package com.antg.leetcode.jz.jo75.str;

import java.util.HashSet;
import java.util.Set;

/**
* @author:Antg
* @create: 2023/8/1
* @Description:
 * 表示数值的字符串
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_20 {
    public static void main(String[] args) {
        System.out.println(isNumber("4e+"));
        System.out.println(isDecimal("+"));
        System.out.println(isInteger("+"));

    }

    public static boolean isNumber(String s) {
        // 先去空格
        String trimStr = s.trim();
        if(trimStr.length()==0){
            return false;
        }
        int eNum=0;
        int ENum=0;
        for (int i = 0; i < trimStr.length(); i++) {
            char c = trimStr.charAt(i);
            if(c=='e'){
                eNum++;
            }
            if(c=='E'){
                ENum++;
            }
        }
        if(eNum+ENum>1){
            return false;
        } else if (eNum==1 && ENum==0 && trimStr.length()>=3) {
            String[] es = trimStr.split("e");

            if(es.length<2 || (es[0].length()==0 || es[1].length()==0) || (!isInteger(es[0] ) && !isDecimal(es[0])) || !isInteger(es[1])){
                return false;
            }

        } else if (eNum==0 && ENum==1 && trimStr.length()>=3) {
            String[] es = trimStr.split("E");
            if((es.length<2 || es[0].length()==0 || es[1].length()==0) || (!isInteger(es[0] ) && !isDecimal(es[0])) || !isInteger(es[1])){
                return false;
            }
        } else{
            if(!isInteger(trimStr) && !isDecimal(trimStr)){
                return false;
            }
        }

        return true;

    }

    // 是否是小数
    public static boolean isDecimal(String s){
        // 先去空格
        String trimStr = s.trim();
        int pointNum=0;
        int symbolNum=0;
        char head = trimStr.charAt(0);
        if(head=='.'){
            pointNum++;
        }
        if(head=='+' || head =='-'){
            symbolNum++;
        }
        if(pointNum==0 && symbolNum==0 && (head<48 || head>57)){
            return false;
        }
        for (int i = 1; i < trimStr.length(); i++) {
            char c = trimStr.charAt(i);
            if(c=='.'){
                pointNum++;
                // .只能出现一次
                if(pointNum>1){
                    return false;
                }
            }
            if(c=='+' || c=='-'){
                return false;
            }
            // 不能出现其他非法字符
            if(c!='.' && c!='+' && c!='-' && (c<48 || c>57)){
                return false;
            }
        }
        if(pointNum!=1 || ((pointNum==1 || symbolNum==1) && trimStr.length()==1)){
            return false;
        }
        return true;
    }
    // 是否是整数
    public static boolean isInteger(String s){
        // 先去空格
        String trimStr = s.trim();
        char head = trimStr.charAt(0);
        if(trimStr.length()==1 && (head=='+' || head=='-')){
            return false;
        }
        if(head=='+'|| head=='-' || (head>=48 && head<=57)){
            for (int i = 1; i < trimStr.length(); i++) {
                char c = trimStr.charAt(i);
                if(c<48 || c>57){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

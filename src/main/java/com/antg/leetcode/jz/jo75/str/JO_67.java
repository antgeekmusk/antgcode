package com.antg.leetcode.jz.jo75.str;
/**
* @author:Antg
* @create: 2023/8/2
* @Description: https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 67. 把字符串转换成整数
*/
public class JO_67 {
    // 定义几种字符类型
    enum CharType{
        CHAR_NUMBER,//0-9
        CHAR_SIGN,//+-
        CHAR_OTHER, // 其他
    }
    public static void main(String[] args) {
        JO_67 jo67 = new JO_67();
        System.out.println(jo67.strToInt("42"));
//        System.out.println(Math.pow(10,0));

    }

    public int strToInt(String str) {
        String trimStr = str.trim();
        if(trimStr.length()==0) return 0;
        int subLength=0;
        boolean singAppear=false;// 判断第一位+-号是否出现过
        if(getCharType(trimStr.charAt(0))==CharType.CHAR_SIGN){
            singAppear=true;
            if(trimStr.length()==1){
                return 0;
            }
        }
        for (int i = 0; i < trimStr.length(); i++) {
            char c = trimStr.charAt(i);
            CharType charType = getCharType(c);
            if((charType==CharType.CHAR_NUMBER && i>=1) || ((charType==CharType.CHAR_NUMBER || charType==CharType.CHAR_SIGN) && i==0)){
                subLength++;
            }else{
                break;
            }
        }
        String substring = trimStr.substring(0, subLength);
        if(subLength==0){
            return 0;
        }
        long tmp = 0;
        for(int i = substring.length()-1; i >=0; i--) {
            if(i!=0){
                tmp+=(substring.charAt(i)-48)*Math.pow(10,substring.length()-i-1);
            }else{
                if(singAppear && substring.charAt(i)=='-'){
                        tmp*=-1;
                }else if(singAppear && substring.charAt(i)=='+'){
                        tmp*=1;
                }else{
                    tmp+=(substring.charAt(i)-48)*Math.pow(10,substring.length()-1);
                }
            }
        }
        if(tmp>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(tmp<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)tmp;
        }

    }

    public CharType getCharType(char c){
        if(c>=48 && c<=57){
            return CharType.CHAR_NUMBER;
        }else if(c=='+' || c=='-'){
            return CharType.CHAR_SIGN;
        }else {
            return null;
        }
    }
}

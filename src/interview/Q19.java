package interview;

/**
 * Created by GuoWeiyu on 2017/07/29.
 * Description: 匹配正则表达式的".","*"
 */
public class Q19 {
    private static char[] string, pattern;
    private static int strN, patN;

    public static void main(String[] args) {
        String str = "aaa";
        String pat = "ab*ac*a";
        string = str.toCharArray();
        pattern = pat.toCharArray();
        strN = string.length;
        patN = pattern.length;

        System.out.println(match(0,0));
    }

    private static boolean match(int strPtr, int patPtr) {
        // 1、同时到达末尾，则匹配成功
        if (strPtr == strN && patPtr == patN) {
            return true;
        }
        // 2、Pattern结束，String未结束，则失败
        if (strPtr < strN && patPtr == patN) {
            return false;
        }
        // 3、String结束，Pattern未结束，仍然有可能匹配
        // pattern中当前字符的下一字符为"*"，则可能匹配0-n次
        if (patPtr < patN - 1 && pattern[patPtr+1] == '*') {
            if (strPtr != strN && (string[strPtr] == pattern[patPtr] || pattern[patPtr] == '.')) {
                return match(strPtr, patPtr + 2) ||         //匹配0次
                        match(strPtr + 1, patPtr + 2) ||    //匹配1次
                        match(strPtr + 1, patPtr);          //匹配n次
            } else {
                return match(strPtr, patPtr + 2);       //匹配0次
            }
        }
        // 常规情况，字符匹配
        if (strPtr != strN && (string[strPtr] == pattern[patPtr] || pattern[patPtr] == '.')) {
            return match(strPtr + 1, patPtr + 1);
        }
        return false;
    }
}

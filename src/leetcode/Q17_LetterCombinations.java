package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-09.
 */
public class Q17_LetterCombinations {
    public static void main(String[] args) {
        String str = "";
        System.out.println(letterCombinations(str));
    }

    /**
     * 递归
     */
    public static List<String> letterCombinations(String digits) {
        char[][] chars={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
                {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},
                {'w','x','y','z'}};         //每个数字键对应的字符
        List<String> ans=new ArrayList<>();
        if(digits.isEmpty())
            return ans;
        func(0,"",digits,chars,ans);
        return ans;
    }

    private static void func(int index,String strAns,String srcStr,char[][] chars,List<String> listAns){
        if(index==srcStr.length()){       //已经遍历到最后一个数字
            listAns.add(strAns);
            return;     //退出
        }

        int num = srcStr.charAt(index)-48;     //第index个字符表示的数字
        for(int i=0;i<chars[num].length;i++) {
            func(index+1,strAns+chars[num][i],srcStr,chars,listAns);
        }
    }
}

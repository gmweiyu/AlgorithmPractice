package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-12.
 */
public class Q22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        String str = "";
        if(n>0)
            foo(result,str,n,0, 0);
        return result;
    }

    /**
     * 递归：当前左括号数l < 总对数n：可以添加左括号
     *      当前右括号数r < 左括号数l：可以添加右括号
     * 每次需要回溯新添加的左括号
     */
    private static void foo(List<String> result, String str,int n, int l, int r) {
        if (l == n) {       //如果左括号数==n，补全右括号
            for(int i=0;i<n-r;i++)
                str+=')';
            result.add(str);
            return;     //递归出口
        }

        str+='(';
        foo(result,str,n,l+1,r);
        str=str.substring(0,str.length() - 1);     //回溯

        if (r < l) {
            str+=')';
            foo(result, str, n, l, r + 1);
            str=str.substring(0,str.length() - 1);
        }
    }

    private void helper(int l, int r, String item, ArrayList<String> res)
    {
        if(r<l)
            return;
        if(l==0 && r==0)
        {
            res.add(item);
        }
        if(l>0)
            helper(l-1,r,item+"(",res);
        if(r>0)
            helper(l,r-1,item+")",res);
    }
}

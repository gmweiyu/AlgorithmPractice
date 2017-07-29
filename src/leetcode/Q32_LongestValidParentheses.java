package leetcode;

import java.util.Stack;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q32_LongestValidParentheses {
    public static void main(String[] args) {
        String s=")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int ans=0,aux=0,t=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else{
                if (stack.isEmpty()) {      //如果栈里已经没有'('与之匹配，则退出
                    aux=aux+t;
                    ans = Math.max(ans, aux);
                    t=aux;
                    aux=0;
                } else {
                    stack.pop();
                    aux+=2;
                    if(stack.isEmpty()){
                        t=aux;
                        aux=0;
                    }
                }
            }
        }
        ans = Math.max(ans, aux);   //遍历到结尾，但还未计算结果
        return ans;
    }
}

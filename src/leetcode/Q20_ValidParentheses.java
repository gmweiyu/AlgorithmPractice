package leetcode;

import java.util.Stack;

/**
 * Created by Weasley on 2017-03-10.
 */
public class Q20_ValidParentheses {
    public static void main(String[] args) {
        String s="){";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.length()<2||s.length()%2!=0)
            return false;
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<chars.length;i++) {
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{')
                stack.push(chars[i]);
            else if(stack.isEmpty())
                return false;
            else if(chars[i]==')') {
                if (stack.pop() != '(') return false;
            }else if(chars[i]==']'){
                if(stack.pop()!='[')    return false;
            }else if(chars[i]=='}'){
                if(stack.pop()!='{')    return false;
            }
        }
        return stack.isEmpty();
    }

}

package leetcode;

import java.util.Stack;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q32_LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()(())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                // 当前栈中不存在与之匹配的'('，则start不可能在当前i，即出现“断裂“，重新计数
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    // 分两种情况考虑，后一种实际为 i-(stack.peek()+1)+1
                    int temp = stack.isEmpty() ? i - start + 1 : i - stack.peek();
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
}

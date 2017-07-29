package leetcode;

/**
 * Created by GuoWeiyu on 2017-05-16.
 */
public class Q10_Regex {
    public static void main(String[] args) {
        str = "a".toCharArray();
        pattern = "aa".toCharArray();
        System.out.println(matchPattern(0, 0));
    }

    private static char[] str, pattern;

    private static boolean matchPattern(int s, int p) {
        if (s == str.length && p == pattern.length) {       //同时到末尾，则匹配
            return true;
        }
        if (s != str.length && p == pattern.length) {       //pattern先结束，则失败
            return false;
        }
        if (p < pattern.length - 1 && pattern[p + 1] == '*') {    //第二个字符为'*'
            if (s != str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                return matchPattern(s, p + 2) ||
                        matchPattern(s + 1, p + 2) ||
                        matchPattern(s + 1, p);
            } else {
                return matchPattern(s, p + 2);
            }
        }
        //第二个字符不为'*'
        if (s != str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
            return matchPattern(s + 1, p + 1);
        }
        return false;
    }
}

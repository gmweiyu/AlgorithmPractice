package leetcode;

/**
 * Created by Weasley on 2017-03-25.
 */
public class Q58_LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hllo sks l"));
    }

    public static int lengthOfLastWord(String s) {
        int ans=0,i=s.length()-1;
        //逆向找到第一个非空字符
        while (i >= 0&&s.charAt(i)==' ') {
            i--;
        }
        while(i>=0&&s.charAt(i)!=' '){
            ans++;
            i--;
        }
        return ans;
    }
}

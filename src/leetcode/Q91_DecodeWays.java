package leetcode;

/**
 * Created by Weasley on 2017-04-05.
 */
public class Q91_DecodeWays {
    public static void main(String[] args) {
        String s="10";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if(s==null) return 0;
        int index;
        for(index=0;index<s.length();index++){
            if(s.charAt(index)!='0')    break;
        }
        s=s.substring(index,s.length());
        if(s.length()==0)  return 0;
        int[] dp=new int[s.length()+1]; //前i个数组成的方法
        dp[0]=1;
        dp[1]=1;        //一个数只有一种情况
        for(int i=2;i<=s.length();i++) {
            //注意：i-1为当前字符
            if(s.charAt(i-2)=='1'||
                    (s.charAt(i-2)=='2'&&s.charAt(i-1)<'7'))
                dp[i]=dp[i-2]+dp[i-1];
            else
                dp[i]=dp[i-1];
        }
        return dp[s.length()];
    }
}

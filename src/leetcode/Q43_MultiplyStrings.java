package leetcode;

/**
 * Created by Weasley on 2017-03-18.
 */
public class Q43_MultiplyStrings {
    public static void main(String[] args) {
        String num1="289";
        String num2="758";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String num1, String num2) {
        char[] chars1=num1.toCharArray(),chars2=num2.toCharArray();
        int n1=num1.length(),n2=num2.length(),n=n1+n2;
        int[] num=new int[n];
        int k=n1+n2-2;      //(n1-1)+(n2-2)
        for(int i=0;i<n1;i++) {
            for(int j=0;j<n2;j++) {
                //注意i、j的方向是从高位至低位
                num[k-i-j]+=(chars1[i]-'0')*(chars2[j]-'0');
            }
        }
        int carryBit=0;     //进位
        for(int i=0;i<n;i++) {
            num[i]+=carryBit;
            carryBit=num[i]/10;
            num[i]=num[i]%10;
        }
        int i=k+1;      //n1+n2-1
        while(i>=0&&num[i]==0)    i--;        //除去前置的0
        if(i<0)     return "0";     //乘积为0
        StringBuilder ans=new StringBuilder();
        for(;i>=0;i--) {
            ans.append(num[i]);
        }
        return String.valueOf(ans);
    }
}

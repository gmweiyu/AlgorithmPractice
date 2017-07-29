package leetcode;

/**
 * Created by Weasley on 2017-03-27.
 */
public class Q67_AddBinary {
    public static void main(String[] args) {
        String a="0";
        String b="10";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        int m=a.length()-1,n=b.length()-1;
        String ans="";
        int aux=0;
        while (m >= 0 && n >= 0) {
            int t=(a.charAt(m--)-'0')+(b.charAt(n--)-'0')+aux;
            ans=(t%2)+ans;
            aux=t/2;
        }
        int index=Math.max(m,n);
        while(index>=0){
            int t;
            if(m>n) t=(a.charAt(index--)-'0')+aux;
            else    t=(b.charAt(index--)-'0')+aux;
            ans=(t%2)+ans;
            aux=t/2;
        }
        if(aux!=0) ans=(aux)+ans;
        return String.valueOf(ans);
    }
}

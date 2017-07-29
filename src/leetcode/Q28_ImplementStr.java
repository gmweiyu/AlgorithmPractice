package leetcode;

/**
 * Created by Weasley on 2017-03-15.
 */
public class Q28_ImplementStr {
    public static void main(String[] args) {
        String haystack="skdksjdfk",needle="ks";
        System.out.println(strStr(haystack,needle));
    }

    /**
     * 暴力
     */
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty())        return 0;
        char[] ch=haystack.toCharArray(),cn=needle.toCharArray();
        int n=haystack.length()-needle.length()+1;
        for(int i=0;i<n;i++) {
            int j=i,k=0;        //j:harstack;k:needle
            while (j < haystack.length() && k < needle.length() && ch[j] == cn[k]) {
                j++;
                k++;
            }
            if(k==needle.length())
                return i;
        }
        return -1;
    }
}

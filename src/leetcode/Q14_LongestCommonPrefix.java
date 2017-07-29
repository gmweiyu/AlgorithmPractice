package leetcode;

/**
 * Created by Weasley on 2017-03-08.
 */
public class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        int index=0;
        while (true) {
            for(int i=0;i<strs.length-1;i++) {
                if(index==strs[i].length()||
                        index==strs[i+1].length()||
                strs[i].charAt(index)!=strs[i+1].charAt(index))
                    return strs[0].substring(0,index);
            }
            index++;
        }
    }
}

package leetcode;

/**
 * Created by Weasley on 2017-03-28.
 */
public class Q71_SimplifyPath {
    public static void main(String[] args) {
        String path="/../";
        System.out.println(getPath(path));
    }

    public static String getPath(String path) {
        String ans="";
        if(path==null||path.length()==0)
            return ans;
        for(int i=path.length()-2;i>=0;i--) {
            ans=path.charAt(i)+ans;
            if(path.charAt(i)=='/')
                break;
        }
        return ans;
    }
}

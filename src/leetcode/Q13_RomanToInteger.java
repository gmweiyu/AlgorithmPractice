package leetcode;

/**
 * Created by Weasley on 2017-03-14.
 */
public class Q13_RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt(""));
    }

    public static int romanToInt(String s) {
        if(s.isEmpty())
            return 0;
        int ans = 0, index = 0,i=0;
        char[] chars = s.toCharArray();
        char[][] romans = {{'M','?','?'},
                           {'C','D','M'},
                           {'X','L','C'},
                           {'I','V','X'}};
        while (i < chars.length) {
            int auxNum = 0,l=0,r=0;
            while (i<chars.length) {
                if (chars[i]==romans[index][0]){
                    l++;
                } else if (chars[i] == romans[index][1]) {
                    auxNum=5-l;
                    l=0;
                } else if (chars[i] == romans[index][2]) {
                    auxNum=10-l;
                    l=0;
                } else {
                    break;
                }
                i++;
            }
            auxNum+=l;
            ans=ans*10+auxNum;
            index++;
        }
        for(int t=4;index<4;index++)
            ans*=10;
        return ans;
    }
}

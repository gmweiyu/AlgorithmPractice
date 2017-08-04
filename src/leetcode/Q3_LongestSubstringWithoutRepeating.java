package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Weasley on 2017-02-23.
 * AC
 */
public class Q3_LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String str = "dskdjzsa";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 采用滑动窗口来实现
     * O(2n)->O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
//        Set<Character> subs = new HashSet<>();
        List<Character> subs=new ArrayList<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // 更新窗口的大小
            if (!subs.contains(s.charAt(j))){
                subs.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                //注意使用List时需要强转
                subs.remove((Character) s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * O(n)，即遍历一遍
     */
    public static int lengthOfLongestSubstring_2(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int ans=0;
        int n=s.length();
        for(int i=0,j=0;j<n;j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

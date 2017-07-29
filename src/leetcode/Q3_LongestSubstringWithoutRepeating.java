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
        String str = "d";
        System.out.println(lengthOfLongestSubstring_3(str));
    }

    public static  int lengthOfLongestSubstring(String s) {
        int res=0;
        List<Character> visited=new ArrayList<>();

        char[] array=s.toCharArray();       //转换成字符数组
        if (array.length == 0) {
            return res;
        } else {
            visited.add(array[0]);
            int length=res=1;
            for(int i=1;i<array.length;i++) {
                if (array[i] == array[i - 1]) {
                    length=visited.size();
                    res = (length > res) ? length : res;
                    visited.clear();
                } else if (visited.contains(array[i])) {
                    int index = visited.indexOf(array[i]);
                    for (int i1=0;i1<=index;i1++) {
                        visited.remove(0);      //注意每次list的index会变化
                    }
                }
                visited.add(array[i]);
                length=visited.size();
                res = (length > res) ? length : res;
            }
        }
        return res;
    }

    /**
     * 采用滑动窗口来实现
     * O(2n)->O(n)
     */
    public static int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
//        Set<Character> set = new HashSet<>();
        List<Character> set=new ArrayList<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                //注意使用List时需要强转
                set.remove((Character)s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * O(n)，即遍历一遍
     */
    public static int lengthOfLongestSubstring_3(String s) {
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

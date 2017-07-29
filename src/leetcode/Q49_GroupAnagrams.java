package leetcode;

import java.util.*;

/**
 * Created by Weasley on 2017-03-20.
 */
public class Q49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(anagram(strs));
    }

    public static List<List<String>> anagram(String[] strs){
        //将每一个string排序，然后按照key存入map
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            char[] aux=strs[i].toCharArray();
            Arrays.sort(aux);
            String key=Arrays.toString(aux);
            if (!map.containsKey(key)) {
                List list = new ArrayList();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}

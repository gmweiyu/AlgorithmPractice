package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-26.
 */
public class Q60_PermutationSequences {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,6));
    }

    public static String getPermutation(int n, int k) {
        if(n<1) return "";
        StringBuilder ans=new StringBuilder();
        int factorial=1;    //每一组含有的排列数目
        for(int i=2;i<n;i++)    factorial*=i;
        List<Integer> numList=new ArrayList<>();
        for(int i=1;i<=n;i++)   numList.add(i);
        int round=n-1;  //回合数，需要n回，即取n个数字
        k--;    //对应数组下标
        while (round >= 0) {
            int index=k/factorial;      //第几组
            k%=factorial;       //确定一个数字后，更新k
            ans.append(numList.get(index));
            numList.remove(index);
            if(round>0)
                factorial/=round;   //更新一组含有的排列数目
            round--;
        }
        return ans.toString();
    }
}

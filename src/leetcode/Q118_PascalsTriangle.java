package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/08/11.
 * Description:
 */
public class Q118_PascalsTriangle {
    public static void main(String[] args) {
        int numRows=0;
        List<List<Integer>> ans = generate(numRows);
        System.out.println(ans);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 第i行有i+1个数字
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    // 根据上一行的数字，计算当前行的数字
                    List<Integer> lastTemp=ans.get(i-1);
                    int left=lastTemp.get(j-1);
                    int up=lastTemp.get(j);
                    temp.add(left + up);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

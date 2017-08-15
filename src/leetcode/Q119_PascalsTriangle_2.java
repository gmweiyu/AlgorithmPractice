package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/08/11.
 * Description:
 */
public class Q119_PascalsTriangle_2 {
    public static void main(String[] args) {
        int rowIndex=2;
        System.out.println(getRow(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            // 从后向前遍历，优化空间复杂度。类似动态规划中的优化
            ans.add(1);
            for (int j = i-1; j > 0 ; j--) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
        }
        return ans;
    }
}

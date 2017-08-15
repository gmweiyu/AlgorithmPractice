package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-04-07.
 */
public class Q120_Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);

        list = new ArrayList<>();     //使用clear(),实际上是同一个list
        list.add(3);
        list.add(4);
        triangle.add(list);

        list=new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);

        list=new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);

        System.out.println(minimumTotal_2(triangle));
    }

    /**
     * 自顶向下遍历
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int n = triangle.size();      //层数
        for (int i = 1; i < n; i++) {      //第2层到n层
            List<Integer> current = triangle.get(i);
            List<Integer> last=triangle.get(i-1);
            for (int j = 0; j < current.size(); j++) {     //第1列到最后1列
                if (j == 0) {       //第一列
                    current.set(j, last.get(0) + current.get(0));
                } else if (j == current.size() - 1) {      //最后一列
                    current.set(j, last.get(j - 1) + current.get(j));
                } else {
                    current.set(j, Math.min(last.get(j - 1), last.get(j)) + current.get(j));
                }
            }
        }
        for (int i : triangle.get(triangle.size() - 1)) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

    /**
     * 自底向上遍历，效率相同，但代码会比较简洁，无需最后比较出最小值
     * @param triangle
     * @return
     */
    private static int minimumTotal_2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int ans=0;
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> current=triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j <= i ; j++) {
                current.set(j,Math.min(next.get(j),next.get(j+1))+current.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}

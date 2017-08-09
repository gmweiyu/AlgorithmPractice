package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description: 和为s的连续正整数序列
 */
public class Q57_2 {
    public static void main(String[] args) {
        int target=15;
        System.out.println(findSequences(target));
    }

    private static List<List<Integer>> findSequences(int target) {
        if (target <= 2) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();

        // 遍历过程中记录当前序列首尾以及序列和
        int head = 1, tail = 2;
        int sum = 1 + 2;

        while (head<=target/2) {
            if (sum == target) {
                List<Integer> sequence = new ArrayList<>();
                for (int i = head; i <= tail; i++) {
                    sequence.add(i);
                }
                ans.add(sequence);
                sum+=(++tail);
            } else if (sum < target) {
                sum+=(++tail);
            } else {
                sum-=(head++);
            }
        }
        return ans;
    }
}

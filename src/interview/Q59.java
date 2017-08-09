package interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description: 滑动窗口的最大值
 */
public class Q59 {
    public static void main(String[] args) {

    }

    private static List<Integer> maxValues(int[] nums,int size) {
        if (nums == null || nums.length < size) {
            return null;
        }
        List<Integer> ans=new ArrayList<>();

        // 双端队列存储当前可能的最大值的index
        Deque<Integer> deque=new LinkedList<>();

        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

        }
        return ans;
    }
}

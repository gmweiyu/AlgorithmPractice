package leetcode;

import java.util.Stack;

/**
 * Created by Weasley on 2017-04-02.
 */
public class Q84_LargestRectangle {
    public static void main(String[] args) {
        int[] nums={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
        int ans=0;
        if(heights==null||heights.length==0)    return ans;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                //出栈，直到所有元素都小于height[i]，保持递增
                int index=stack.pop();
                // 不算当前元素，所以计算长度时不需要+1
                int area=stack.isEmpty()?i*heights[index]:(i-stack.peek()-1)*heights[index];
                ans = Math.max(ans, area);
            }
            stack.push(i);     //入栈新元素，维护的是索引
        }
        // 处理栈中剩余元素，可看作数组结尾有一个高度0元素
        while (!stack.isEmpty()) {
            int index=stack.pop();
            int area=stack.isEmpty()?heights[index]*heights.length:(heights.length-stack.peek()-1)*heights[index];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}

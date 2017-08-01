package interview;

import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 判断栈的压入、弹出序列是否匹配（假设栈中没有重复元素）
 */
public class Q31 {
    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 3, 5, 2};

        System.out.println(match(pushOrder, popOrder));
    }

    /**
     * 判断给定的栈压入、弹出序列是否匹配，即是否存在此弹出序列对应压入序列
     *
     * @param pushOrder 栈的压入序列
     * @param popOrder  栈的弹出序列
     * @return 是否匹配
     */
    private static boolean match(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null) {
            return false;
        }
        int pushOrderLength = pushOrder.length;
        int popOrderLength = popOrder.length;
        if (pushOrderLength < popOrderLength) {
            return false;
        }
        // 模拟当前栈的压入、弹出情况
        Stack<Integer> stack = new Stack<>();
        // 标识在pushOrder中指定index的元素是否已经被使用过（已经被入栈、弹出）
        boolean[] visit = new boolean[pushOrderLength];
        // 遍历模拟栈的弹出序列
        for (int i = 0; i < popOrderLength; i++) {
            // 如果当前stack为null 或 栈顶值不为弹出值
            if (stack.isEmpty() || popOrder[i] != stack.peek()) {
                for (int j = 0; j < pushOrderLength; j++) {
                    // 当前入栈元素的前置元素入栈
                    if (!visit[j]) {
                        visit[j] = true;
                        stack.push(pushOrder[j]);
                    }
                    // 找到栈顶值，退出循环
                    if (pushOrder[j] == popOrder[i]) {
                        break;
                    }
                }
            }
            if (popOrder[i] != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

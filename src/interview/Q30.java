package interview;

import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017/08/01.
 * Description: 包含min函数的栈
 */
public class Q30 {
    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack<>();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }

    private static class MinStack<T extends Comparable<T>> {
        /* 原始数据栈 */
        private Stack<T> mData = new Stack<T>();
        /* 用于存放当前栈内最小元素的辅助栈*/
        private Stack<T> mMin = new Stack<T>();

        public T pop() {
            // min栈需要同步pop操作
            mMin.pop();
            return mData.pop();
        }

        public void push(T t) {
            mData.push(t);
            // 如果新入栈的元素比当前最小元素还小，则加入min栈
            if (mMin.isEmpty() || t.compareTo(mMin.peek()) < 0) {
                mMin.push(t);
            }
            // 否则加入min栈内原有的最小元素
            else {
                mMin.push(mMin.peek());
            }
        }

        public T min() {
            return mMin.peek();
        }
    }
}

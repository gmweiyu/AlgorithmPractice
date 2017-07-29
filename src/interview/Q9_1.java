package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by GuoWeiyu on 2017/07/25.
 * Description: 使用两个栈实现队列
 */
public class Q9_1 {
    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>();
        System.out.println(queue.delete());

        Queue<Integer> queue1=new LinkedList<>();
        System.out.println(queue1.poll());
    }
    private static class MyQueue<T>{
        Stack<T> stack1=new Stack<T>();
        Stack<T> stack2=new Stack<T>();

        public void append(T t) {
            stack1.push(t);
        }

        public T delete(){
            // 当stack2为空，即弹出栈没有元素，则把stack1转移
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty()?null:stack2.pop();
        }
    }
}

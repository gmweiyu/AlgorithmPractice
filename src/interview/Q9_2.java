package interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GuoWeiyu on 2017/07/25.
 * Description: 使用两个队列实现栈
 */
public class Q9_2 {

    public static void main(String[] args) {
        MyStack<Integer> stack=new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        stack.push(4);
        System.out.println(stack.poll());
        stack.push(5);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }

    private static class MyStack<T> {
        Queue<T> queue=new LinkedList<T>();     //入栈，出栈
        Queue<T> storeQueue=new LinkedList<T>();    //临时存放元素

        public void push(T t) {
            queue.offer(t);
        }

        public T poll() {
            if (queue.isEmpty()) {
                return null;
            }
            while (queue.size() > 1) {
                storeQueue.offer(queue.poll());
            }
            T polled=queue.poll();
            swapQueue();
            return polled;
        }

        // 交换两个queue的引用
        public void swapQueue() {
            Queue<T> temp=queue;
            queue=storeQueue;
            storeQueue=temp;
        }
    }

}

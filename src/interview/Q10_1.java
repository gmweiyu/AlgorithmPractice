package interview;

/**
 * Created by GuoWeiyu on 2017/07/25.
 * Description: 求Fibonacci的第n项
 */
public class Q10_1 {
    public static void main(String[] args) {
        int n=20;
        System.out.println(cyclic(n));
        System.out.println(recursive(n));
    }

    // 循环方法
    public static int cyclic(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f0=0;
        int f1=1;
        int f2=0;
        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0=f1;
            f1=f2;
        }
        return f2;
    }

    // 递归方法
    public static int recursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursive(n - 1) + recursive(n - 2);
    }
}

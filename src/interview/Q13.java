package interview;

/**
 * Created by GuoWeiyu on 2017/07/26.
 * Description: 机器人走格子，不能进入x/y各位数和>18
 */
public class Q13 {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int res=0;
    private static int m,n;
    private static boolean[][] vis;
    public static void main(String[] args) {
        m=10;
        n=10;
        vis=new boolean[m][n];
        fun(0,0);
        System.out.println(res);
    }

    private static void fun(int x, int y) {
        int sum = compute(x, y);
        if (sum > 18) {
            return;
        }
        res++;
        for (int[] d : dir) {
            int newX=x+d[0],newY=y+d[1];
            if (newX >= 0 && newX<n &&newY >= 0&&newY<m
                    &&!vis[newX][newY]) {
                vis[newX][newY]=true;
                fun(newX, newY);
            }
        }
    }

    private static int compute(int x, int y) {
        return internalCompute(x)+internalCompute(y);
    }

    /**
     * 计算各位数和
     */
    private static int internalCompute(int num) {
        int sum=0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

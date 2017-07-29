package interview;

/**
 * Created by GuoWeiyu on 2017/07/26.
 * Description:
 */
public class Q12 {
    private static int n;
    private static char[] target;

    private static char[][] map = {
            {'a', 'b', 't', 'g'},
            {'c', 'f', 'c', 's'},
            {'j', 'd', 'e', 'h'}
    };

    private static int row,col;
    private static boolean vis[][];
    public static void main(String[] args) {
        target = "bfct".toCharArray();
        n = target.length;
        row = map.length;
        col = map[0].length;
        vis=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (fun(0, i, j)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    private static boolean fun(int index, int x, int y) {
        if (index == n) {
            return true;
        }

        boolean hasPath=false;
        if (x >= 0 && x < col && y >= 0 && y < row
                && target[index] == map[x][y]
                && !vis[x][y]) {
            vis[x][y] = true;
            hasPath=fun(index + 1, x + 1, y) ||
                    fun(index + 1, x - 1, y) ||
                    fun(index + 1, x, y + 1) ||
                    fun(index + 1, x, y - 1);
            if (!hasPath) {
                vis[x][y]=false;
            }
        }
        return hasPath;
    }
}

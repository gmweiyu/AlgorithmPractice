package leetcode;

import java.util.LinkedList;

/**
 * Created by Weasley on 2017-04-06.
 */
public class Q200_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    //求无向图的连通分量的数目，参考算法P349
    public static int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)   return 0;
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j]=='1') {
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }

    //将访问过的格子置为非1和非0的数字作为标记
    private static void dfs(char[][] grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&
                grid[i][j]=='1'){
            grid[i][j]='2';     //变为非1的数字
            //向四个方向dfs
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
    }

    //同样的思路，使用bfs
    private static void bfs(char[][] grid,int i,int j){
        grid[i][j]=2;
        LinkedList<Integer> queue=new LinkedList<>();
        int code=i*grid[0].length+j;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code=queue.poll();
            int row=code/grid[0].length;
            int col=code%grid[0].length;
            //以(row,col)为中心向四个方向搜索
            if(row>0&&grid[row-1][col]=='1'){
                queue.offer((row-1)*grid[0].length+col);
                grid[row-1][col]='2';
            }
            if (row < grid.length - 1 && grid[row + 1][col] == '1') {
                queue.offer((row+1)*grid[0].length+col);
                grid[row+1][col]='2';
            }
            if (col > 0 && grid[row][col - 1] == '1') {
                queue.offer(row*grid[0].length+col-1);
                grid[row][col-1]='2';
            }
            if (col < grid[0].length - 1 && grid[row][col + 1] == '1') {
                queue.offer(row*grid[0].length+col+1);
                grid[row][col+1]='2';
            }
        }
    }
}

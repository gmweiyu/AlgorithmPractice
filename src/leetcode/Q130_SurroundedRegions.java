package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Weasley on 2017-04-06.
 */
public class Q130_SurroundedRegions {
    public static void main(String[] args) {
        char[][] board={{'X','O','X','X'},
                        {'O','X','O','X'},
                        {'X','O','X','O'},
                        {'O','X','O','X'},
                        {'X','O','X','O'},
                        {'O','X','O','X'}};
        solve(board);
        for(char[] c:board){
            System.out.println(Arrays.toString(c));
        }
    }

    public static void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)    return;
        //将边缘的'0'置为'#'
        for(int i=0;i<board.length;i++) {
            fill_2(board,i,0);        //第一列
            fill_2(board,i,board[0].length-1);    //最后一列
        }
        for(int j=0;j<board[0].length;j++){
            fill_2(board,0,j);        //第一行
            fill_2(board,board.length-1,j);       //最后一行
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='O')    board[i][j]='X';
                else if(board[i][j]=='#')   board[i][j]='O';
            }
        }
    }

    //flood fill+bfs,将边缘的'0'置为'#';将中间的'0'置为'X';将边缘的'#'置回'0'
    private static void fill(char[][] board, int i, int j) {
        if(board[i][j]!='O'){
            return;     //如果为'X'或'#'，则不再继续
        }
        board[i][j]='#';    //置为'#'
        LinkedList<Integer> queue=new LinkedList<>();       //bfs辅助队列
        int code=i*board[0].length+j;       //用一个数记录行、列
        queue.offer(code);
        while (!queue.isEmpty()) {      //bfs搜索符合要求的边缘'0'
            code=queue.poll();
            int row=code/board[0].length;       //获取行、列
            int col=code%board[0].length;
            //以(row,col)为中心向四个方向搜索
            if(row>0&&board[row-1][col]=='O'){
                queue.offer((row-1)*board[0].length+col);
                board[row-1][col]='#';
            }
            if (row < board.length - 1 && board[row + 1][col] == 'O') {
                queue.offer((row+1)*board[0].length+col);
                board[row+1][col]='#';
            }
            if (col > 0 && board[row][col - 1] == 'O') {
                queue.offer(row*board[0].length+col-1);
                board[row][col-1]='#';
            }
            if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
                queue.offer(row*board[0].length+col+1);
                board[row][col+1]='#';
            }
        }
    }

    //采用dfs+flood fill,遇到大数据数组会溢出
    private static void fill_2(char[][] board, int i, int j){
        if(i>=0&&i<board.length&&j>=0&&j<board[0].length
                &&board[i][j]=='O'){
            board[i][j]='#';
            fill_2(board,i-1,j);
            fill_2(board,i+1,j);
            fill_2(board,i,j-1);
            fill_2(board,i,j+1);
        }
    }
}

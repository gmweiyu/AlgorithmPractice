package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Weasley on 2017-03-21.
 */
public class Q51_NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
        System.out.println(sum);
    }

    private static int sum=0;

    //使用一维数组存储
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        //book[i]=x : 第i行的皇后在第x列，未放置则为-1
        int[] book=new int[n];
        for(int i=0;i<n;i++)    book[i]=-2147483648;
        dfs(ans,book,0);
        return ans;
    }

    public static void dfs(List<List<String>> ans, int[] book,int row) {
        if(row==book.length){
            List<String> list=new ArrayList<>();
            sum++;
            for(int i=0;i<book.length;i++){
                StringBuilder str=new StringBuilder();
                for(int j=0;j<book.length;j++){
                    if(book[i]==j)  str.append("Q");
                    else            str.append(".");
                }
                list.add(String.valueOf(str));
            }
            ans.add(list);
            return;
        }

        for(int i=0;i<book.length;i++) {
            if(!isOk(book,row,i))   continue;
            book[row]=i;
            dfs(ans,book,row+1);
            book[row]=-2147483648;   //回溯
        }
    }

    private static boolean isOk(int[] book, int row, int col) {
        for(int i=0;i<book.length;i++){
            //判断列
            if(book[i]==col)    return false;
            //判断对角线
            if(Math.abs(row-i)==Math.abs(col-book[i]))  return false;
        }
        return true;
    }


    //使用二维数组存储
    private static void dfs_2(int index,int[][] visited){
        if(index==visited.length){
            for(int i=0;i<visited.length;i++)
                System.out.println(Arrays.toString(visited[i]));
            System.out.println();
            return;
        }
        for(int i=0;i<visited.length;i++) {
            if (isValid(visited, i, index)) {
                visited[i][index]=1;
                dfs_2(index+1,visited);
                visited[i][index]=0;
            }
        }
    }

    private static boolean isValid(int[][] visited,int i,int j) {
        //分别判断行、列是否合法
        for(int a=0;a<visited.length;a++)
            if(visited[i][a]==1||visited[a][j]==1)
                return false;
        //判断所在斜线上是否合法
        //正对角线
        int a=i-Math.min(i,j);
        int b=j-Math.min(i,j);
        while (a < visited.length && b < visited.length) {
            if(visited[a][b]==1)
                return false;
            a++;
            b++;
        }
        //判断副对角线
        a=i+Math.min(visited.length-1-i,j);
        b=j-Math.min(visited.length-1-i,j);
        while (a >= 0 && b < visited.length) {
            if(visited[a][b]==1)
                return false;
            a--;
            b++;
        }

        return true;
    }
}

package leetcode;

/**
 * Created brow Weaslerow on 2017-03-29.
 */
public class Q79_WordSearch {
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word="ABCB";
        System.out.println(exist(board,word));
    }

    private static int[][] dir={{0,-1},{1,0},{0,1},{-1,0}}; //上右下左

    public static boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean[][] visited=new boolean[m][n];      //只能访问一次
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,1,visited,word,board))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int row,int col,int index,
                              boolean[][] visited,String word,char[][] board){
        //越界
        if(col<0||col==board[0].length||row<0||row==board.length) return false;
        //当前字符与目标word中的某个字符不匹配，或者已经被使用过
        if(board[row][col]!=word.charAt(index-1)||visited[row][col]) return false;
        if(index==word.length())    return true;    //匹配成功
        for(int i=0;i<dir.length;i++){  //四个方向dfs
            visited[row][col]=true;
            if(dfs(row+dir[i][1],col+dir[i][0],index+1,visited,word,board))
                return true;
            visited[row][col]=false;    //回溯
        }
        return false;
    }
}

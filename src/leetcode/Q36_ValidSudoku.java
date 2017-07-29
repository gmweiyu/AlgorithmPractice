package leetcode;

/**
 * Created by Weasley on 2017-03-17.
 */
public class Q36_ValidSudoku {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        int n=board.length;
        //检查行列是否有重复，可优化为两层循环：只遍历对角线格子
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j] != '.') {
                    for(int k=0;k<n;k++) {
                        if(k!=i&&board[k][j]==board[i][j])
                            return false;
                        if(k!=j&&board[i][k]==board[i][j])
                            return false;
                    }
                }
            }
        }
        //检查九宫格
        for(int i=0;i<n;i++) {
            boolean[] used=new boolean[9];
            int c=i/3*3,d=i%3*3;
            for(int a=c;a<c+3;a++) {
                for(int b=d;b<d+3;b++) {
                    char ch=board[a][b];
                    if (ch != '.') {
                        if(used[ch-48-1])   return false;
                        else                used[ch-48-1]=true;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 简洁版本
     */
    public static boolean isValidSudoku_2(char[][] board) {
        for(int i=0;i<9;i++) {
            //对角线上的每一个格子
            //检查行
            boolean[] used=new boolean[9];
            for(int j=0;j<9;j++) {
                if(!isValid(used,board[i][j]))
                    return false;
            }
            //检查列
            used=new boolean[9];
            for(int j=0;j<9;j++) {
                if(!isValid(used,board[j][i]))
                    return false;
            }
        }

        //检查九宫格
        for(int i=0;i<9;i++) {
            boolean[] used=new boolean[9];
            int c=i/3*3,d=i%3*3;
            for(int a=c;a<c+3;a++) {
                for(int b=d;b<d+3;b++) {
                    if(!isValid(used,board[a][b]))
                        return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(boolean[] used,char c){
        if(c=='.')      return true;
        if(used[c-'1'])    return false;
        return used[c-'1']=true;
    }
}

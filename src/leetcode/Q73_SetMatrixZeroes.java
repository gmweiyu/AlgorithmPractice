package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-28.
 */
public class Q73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] nums={{1,2,3},
                      {2,0,3},
                      {2,0,3}};
        setZeroes_3(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    //空间复杂度O(m*n):使用二维数组记录
    public static void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        int m=matrix.length,n=matrix[0].length;
        int[][] flag=new int[m][n];     //标记是否为0
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (matrix[i][j] == 0) {
                    flag[i][j]=1;
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (flag[i][j] == 1) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    //空间复杂度O(m+n)：使用两个一维数组记录
    public static void setZeroes_2(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        int m=matrix.length,n=matrix[0].length;
        boolean[] row=new boolean[m];     //对应的行、列是否为0
        boolean[] col=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0){
                    row[i]=true;    //对应的行列置为true
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(row[i]==true||col[j]==true)
                    matrix[i][j]=0;
            }
        }
    }

    //空间复杂度O(1):使用原数组中的第一行、列记录O(m+n)解法中的行列置0标记，
    //另外使用两个变量记录第一行、列
    public static void setZeroes_3(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        int m=matrix.length,n=matrix[0].length;
        int rowFlag=0,colFlag=0;
        //1：遍历第一行、列，记录是否置0
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) {
                colFlag = 1;
                break;      //有一个0，则不必继续遍历
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                rowFlag=1;
                break;
            }
        }
        //2：使用第一行、列记录后面的置0标记
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //3：重置数组
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[0][j]==0||matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        //4：重置第一行
        if(rowFlag==1){
            for(int i=0;i<n;i++)    matrix[0][i]=0;
        }
        if(colFlag==1){
            for(int i=0;i<m;i++)    matrix[i][0]=0;
        }
    }
}

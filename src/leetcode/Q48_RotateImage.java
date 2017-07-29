package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-03-20.
 */
public class Q48_RotateImage {
    public static void main(String[] args) {
        int[][] nums={{1,2,3},
                      {4,5,6},
                      {7,8,9}};
        rotate_2(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    //使用两个数组空间
    public static void rotate(int[][] matrix) {
        int[][] ans=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                ans[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++)
                matrix[i][j]=ans[i][j];
    }

    //使用一个数组空间
    public static void rotate_2(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++)        //沿着副对角线翻转
            for(int j=0;j<n-i;j++)
                swap(matrix,i,j,n-1-j,n-1-i);
        for(int i=0;i<n/2;i++)      //沿着水平中线翻转
            for(int j=0;j<n;j++)
                swap(matrix,i,j,n-1-i,j);
    }
    private static void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int t=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=t;
    }
}

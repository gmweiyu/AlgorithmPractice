package leetcode;

/**
 * Created by Weasley on 2017-03-28.
 */
public class Q74_Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},
                      {10,11,16,20},
                      {23,30,34,50}};
//        int[][] matrix={{1},{3}};
        int target=23;
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix,int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=m-1;
        //找到所在行
        while (left < right) {      //区别与传统二分法，相差1时应该退出
            if(right-left==1)   break;
            int mid=(left+right)/2;
            if(target>matrix[mid][0])      left=mid;
            else if(target<matrix[mid][0]) right=mid-1;
            else                return true;
        }
        int row=target<matrix[right][0]?left:right;     //确定行
        //找到所在列
        left=0;right=n-1;
        while (left <= right) {
            int mid=(left+right)/2;
            if(target>matrix[row][mid])       left=mid+1;
            else if(target<matrix[row][mid])   right=mid-1;
            else        return true;
        }
        return false;
    }
}

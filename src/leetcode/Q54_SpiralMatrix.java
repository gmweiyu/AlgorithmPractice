package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-21.
 */
public class Q54_SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix={};
        System.out.println(spiral(matrix));
    }

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if (matrix.length==0)
            return ans;
        int beginX=0,endX=matrix[0].length-1;
        int beginY=0,endY=matrix.length-1;
        //分别模拟向右、下、左、上的查找
        while(true){
            for(int i=beginX;i<=endX;i++)   ans.add(matrix[beginY][i]);
            if (++beginY>endY)  break;
            for(int i=beginY;i<=endY;i++)    ans.add(matrix[i][endX]);
            if(beginX>--endX)   break;
            for(int i=endX;i>=beginX;i--)   ans.add(matrix[endY][i]);
            if(beginY>--endY)   break;
            for(int i=endY;i>=beginY;i--)   ans.add(matrix[i][beginX]);
            if(++beginX>endX)   break;
        }
        return ans;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-04-07.
 */
public class Q120_Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(2);
        triangle.add(list);

        list=new ArrayList<>();     //使用clear(),实际上是同一个list
        list.add(3);
        list.add(4);
        triangle.add(list);
//
//        list=new ArrayList<>();
//        list.add(6);
//        list.add(5);
//        list.add(7);
//        triangle.add(list);
//
//        list=new ArrayList<>();
//        list.add(4);
//        list.add(1);
//        list.add(8);
//        list.add(3);
//        triangle.add(list);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int ans=Integer.MAX_VALUE;
        int n=triangle.size();      //层数
        for(int i=1;i<n;i++) {      //第2层到n层
            for(int j=0;j<triangle.get(i).size();j++) {     //第1列到最后1列
                if(j==0){       //第一列
                    triangle.get(i).set(j,triangle.get(i-1).get(0)+triangle.get(i).get(0));
                }else if(j==triangle.get(i).size()-1){      //最后一列
                    triangle.get(i).set(j,triangle.get(i-1).get(j-1)+
                                            triangle.get(i).get(j));
                }else{
                    triangle.get(i).set(j,          //计算
                            Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j))+
                                    triangle.get(i).get(j));
                }
            }
        }
        for(int i:triangle.get(triangle.size()-1)){
            ans=Math.min(ans,i);
        }
        return ans;
    }
}

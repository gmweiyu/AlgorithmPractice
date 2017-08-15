package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.binarySearch;

/**
 * Created by Weasley on 2017-03-08.
 */
@SuppressWarnings("ALL")
public class Q15_3Sum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-2, -1, 0, 3, 1, 5, 7, -5};
//        int[] nums = {0, 0};
        int[] nums = {-2, 0, 1, 1, 2,2};
//        int[] nums = {-2, 0, 0, 2, 2};
//        int index = Arrays.binarySearch(nums, 0, 4, 8);
//        System.out.println(index);
        List<List<Integer>> ans = threeSum_3(nums);
        System.out.println(ans);

    }

    /**
     * 从左右开始查找，设置i、j指向首尾
     * 计算nums[i]+nums[j]
     * 如果>=0:在负数中查找第三个数
     * 如果 <0:在非负数中查找
     */
    public static List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int firstNoneNegative=-1;       //数组中第一个非负数的索引
        int l=0,r=n-1;      //左右指针的初始位置
        List<List<Integer>> ans=new ArrayList<>();
        if(n<3||nums[l]>0||nums[r]<0)       //元素不足3个||没有负数||没有非负数
            return ans;

        for(int i=0;i<n;i++) {
            if(nums[i]>=0){
                firstNoneNegative=i;        //找到第一个非负数的位置
                break;
            }
        }

        for(int i=0;i<=firstNoneNegative;i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;       //如果有重复元素，跳过
            for(int j=n-1;j>i+1;j--) {
                if(j<=n-2&&nums[j]==nums[j+1])
                    continue;

                int twoSum=nums[i]+nums[j];     //两个数的和
                int searchIndex=-1;
                if (twoSum > 0) {
                    if(i<=firstNoneNegative-2)
                        searchIndex = binarySearch(nums, i+1, firstNoneNegative-1, -twoSum);
                }else {
                    if(firstNoneNegative<=j-1)
                        searchIndex = binarySearch(nums, firstNoneNegative, j - 1, -twoSum);
                }
                if (searchIndex >=0) {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[searchIndex]);
                    list.add(nums[j]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    /**
     * for(i from 0 to n)，循环内部再定义j从i+1开始向右、k从n-1开始向左，
     * 计算num[i]+num[j]+num[k]
     * 1、==0：记录，并同时移动j、k
     * 2、>0：说明k取大了，向左移动k
     * 3、<0：说明j取小了，向右移动j
     */
    public static List<List<Integer>> threeSum_3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++) {
            // 处理重复数字
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j=i+1,k=n-1;
            while (j < k) {
                int twoSum=nums[j]+nums[k];
                if (twoSum + nums[i] > 0) {
                    k--;
                } else if (twoSum + nums[i] < 0) {
                    j++;
                } else {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    //注意处理重复情况：同时满足下列三个条件
                    while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]) {
                        j++;
                        k--;
                    }
                }
            }
        }
        return ans;
    }

}

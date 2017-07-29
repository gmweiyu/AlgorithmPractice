package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-02-27.
 * 要求O(log(m+n))
 */
public class Q4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2,5};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays_3(nums1,nums2));
    }

    /**
     * O((m+n)/2)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n= nums2.length;
        int sumSize=m+n;

        double ans=0,tempAns=0;

        int target=0;       //中位数目标位置
        if (sumSize % 2 != 0) {
            target = sumSize / 2;
        } else {
            target = sumSize / 2 - 1;
        }

        int i=0,j=0,count=0;
        int flag=0;

        while (i < m || j < n) {
            if (i == m) {
                ans = nums2[j];
                j++;
            } else if (j == n) {
                ans = nums1[i];
                i++;
            } else {
                int x = nums1[i], y = nums2[j];
                if (x >= y) {
                    ans = nums2[j];
                    j++;
                } else {
                    ans = nums1[i];
                    i++;
                }
            }
            if (count == target) {
                if (sumSize % 2 != 0) {
                    break;
                } else {
                    target++;
                    tempAns+=ans;
                    flag++;
                    if (flag == 2) {
                        break;
                    }
                }
            }
            count++;
        }
        if (sumSize % 2 != 0) {
            return ans;
        } else {
            return tempAns/2;
        }
    }

    /**
     * O(m+n)，可以简化为O((m+n)/2)
     */
    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2){
        int m=nums1.length,n=nums2.length;
        int[] nums = new int[m + n];
        int i=0,j=0,index=0;

        while (i < m || j < n) {
            if (i == m) {
                nums[index++] = nums2[j++];
            } else if (j == n) {
                nums[index++] = nums1[i++];
            } else {
                if (nums1[i] >= nums2[j]) {
                    nums[index++] = nums2[j++];
                } else {
                    nums[index++] = nums1[i++];
                }
            }
        }

        if (nums.length % 2 != 0) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length/2-1]+nums[nums.length/2])/2.0;
        }
    }


    /**
     * 寻找第k大的数字
     */
    public static double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
        int m=nums1.length,n= nums2.length;
        int total=m+n;
        if(total%2==0)
            return (findKth(nums1,m,nums2,n,total/2)+
                    findKth(nums1,m,nums2,n,total/2+1))/2.0;
        else
            return findKth(nums1,m,nums2,n,total/2+1);
    }

    private static double findKth(int[] a, int m, int[] b, int n, int k) {
        //使m总是<n
        if(m>n)     return findKth(b,n,a,m,k);
        if(m==0)    return b[k-1];
        if(k==1)    return Math.min(a[0],b[0]);

        int ia=Math.min(k/2,m),ib=k-ia;     //分别对应数组中的索引
        if(a[ia-1]<b[ib-1])
            return findKth(Arrays.copyOfRange(a,ia,m),m-ia,b,n,k-ia);
        else if (a[ia-1]>b[ib-1])
            return findKth(a,m,Arrays.copyOfRange(b,ib,n),n-ib,k-ib);
        else
            return a[ia-1];
    }
}

package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-04-04.
 */
public class Q88_MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1=new int[7];
        nums1[0]=1;
        nums1[1]=3;
        nums1[2]=5;
        nums1[3]=8;
        int[] nums2={2,4,7};
        merge(nums1,4,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    //从前往后扫描，需要维护第三个数组，可优化为从后往前扫描，取较大值
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3= Arrays.copyOf(nums1,m);
        int i=0,j=0,index=0;
        while (i < m && j < n) {
            if(nums3[i]<=nums2[j]){
                nums1[index++]=nums3[i++];
            }else{
                nums1[index++]=nums2[j++];
            }
        }
        while (i < m) {
            nums1[index++]=nums3[i++];
        }
        while(j<n){
            nums1[index++]=nums2[j++];
        }
    }

    //从后往前扫描
    public static void merge_2(int A[], int m, int B[], int n) {
        if(A==null || B==null)
            return;
        int idx1 = m-1;
        int idx2 = n-1;
        int len = m+n-1;
        while(idx1>=0 && idx2>=0) {
            if(A[idx1]>B[idx2]) {
                A[len--] = A[idx1--];
            }
            else {
                A[len--] = B[idx2--];
            }
        }
        while(idx2>=0) {
            A[len--] = B[idx2--];
        }
    }
}

package leetcode;

import java.util.Arrays;

/**
 * Created by Weasley on 2017-02-27.
 * 要求O(log(m+n))
 */
public class Q4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 寻找第k大的数字
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if (total % 2 == 0)     //偶数，需要另作处理
            return (findKth(nums1, m, nums2, n, total / 2) +
                    findKth(nums1, m, nums2, n, total / 2 + 1)) / 2.0;
        else
            return findKth(nums1, m, nums2, n, total / 2 + 1);
    }

    private static double findKth(int[] a, int m, int[] b, int n, int k) {
        // 使m总是<n
        if (m > n) return findKth(b, n, a, m, k);
        // 较短数组已遍历完，直接在较长数组找第k大
        if (m == 0) return b[k - 1];
        // 找到第1大的数，直接返回两个数组首元素较小者
        if (k == 1) return Math.min(a[0], b[0]);

        // 比较两个数组中k/2位置的元素大小
        int ia = Math.min(k / 2, m), ib = k - ia;
        if (a[ia - 1] < b[ib - 1])
            return findKth(Arrays.copyOfRange(a, ia, m), m - ia, b, n, k - ia);
        else if (a[ia - 1] > b[ib - 1])
            return findKth(a, m, Arrays.copyOfRange(b, ib, n), n - ib, k - ib);
        else
            return a[ia - 1];
    }
}

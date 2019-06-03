package com.yoome.solutions;


/**
 * description:
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0) {
            return 0;
        }

        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int mid = (len1 + len2 + 1) / 2;
        int left = 0;
        int right = len1;
        while (left < right) {
            int pos1 = left + (right - left) / 2;
            int pos2 = mid - pos1;
            if (nums1[pos1] < nums2[pos2 - 1]) {
                left = pos1 + 1;
            } else {
                right = pos1;
            }
        }

        int pos1 = left;
        int pos2 = mid - left;
        int val1 = Math.max(pos1 <= 0 ? Integer.MIN_VALUE : nums1[pos1 - 1],
                            pos2 <= 0 ? Integer.MIN_VALUE : nums2[pos2 - 1]);

        if ((len1 + len2) % 2 == 1) {
            return val1;
        }

        int val2 = Math.min(pos1 >= len1 ? Integer.MAX_VALUE : nums1[pos1],
                            pos2 >= len2 ? Integer.MAX_VALUE : nums2[pos2]);

        return (val1 + val2) * 0.5;
    }
}

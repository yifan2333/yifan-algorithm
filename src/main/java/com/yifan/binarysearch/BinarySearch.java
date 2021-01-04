package com.yifan.binarysearch;

/**
 * <a>https://leetcode-cn.com/problems/binary-search/</a>
 */
public class BinarySearch {

    /**
     * Binary search int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;
    }

}

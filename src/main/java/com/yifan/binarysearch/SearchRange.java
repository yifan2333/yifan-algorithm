package com.yifan.binarysearch;

/**
 * <a>https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/</a>
 * The type Search range.
 */
public class SearchRange {
    /**
     * Search range int [ ].
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = boundLeft(nums, target);
        result[1] = boundRight(nums, target);
        return result;
    }

    private int boundLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    private int boundRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return left;
    }
}

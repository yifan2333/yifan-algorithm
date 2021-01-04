package com.yifan.monotonousstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈
 * <a>https://leetcode-cn.com/problems/next-greater-element-i/submissions/</a>
 */
public class NextGreaterElement {


    /**
     * Next greater element int [ ].
     *
     * @param findNums the find nums
     * @param nums     the nums
     * @return the int [ ]
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            while (!stack.empty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > stack.peek()) {
                stack.pop();
            }

            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(nums[stack.peek()]);
        }

        return res;
    }
}

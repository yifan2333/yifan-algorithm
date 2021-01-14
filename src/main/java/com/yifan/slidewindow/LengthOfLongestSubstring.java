package com.yifan.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复字串
 *
 * @author wuyifan
 * @date 2021年01月13日 16:11
 */
public class LengthOfLongestSubstring {
    /**
     * 最长无重复字串
     *
     * @param s the s
     * @return the int
     * @author wuyifan
     * @date 2021年01月13日 16:11
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> countMap = new HashMap<>(s.length());
        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            countMap.put(c, (countMap.getOrDefault(c, 0) + 1));

            while (countMap.get(c) > 1) {
                Character d = s.charAt(left);
                left++;

                countMap.put(d, (countMap.get(d) - 1));
            }

            res = Math.min(res, right - left);
        }

        return res;
    }
}

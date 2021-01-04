package com.yifan.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Min window.
 */
public class MinWindow {

    /**
     * Min window string.
     *
     * @param s the s
     * @param t the t
     * @return the string
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            Character c = s.charAt(right);

            right++;

            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            while (need.size() == valid) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                Character d = s.charAt(left);

                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();

        System.out.println(minWindow.minWindow("ABAACBAB", "ABC"));
    }

}

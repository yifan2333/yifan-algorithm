package com.yifan.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <a>https://leetcode-cn.com/problems/open-the-lock/</a>
 * 广度有限搜索
 */
public class OpenLock {

    /**
     * Open lock int.
     *
     * @param deadEnds the dead ends
     * @param target   the target
     * @return the int
     */
    public int openLock(String[] deadEnds, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadEnds));

        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                if (dead.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * Plus one string.
     *
     * @param s the s
     * @param j the j
     * @return the string
     */
// 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    /**
     * Minus one string.
     *
     * @param s the s
     * @param j the j
     * @return the string
     */
// 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}

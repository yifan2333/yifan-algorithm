package com.yifan.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}

package com.example.springbootkafka.singleton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors != null && colors.length() > 0) {
            String[] split = colors.split("|");
            String temp = "A";
            int times = 0;
            int index = 0;
            for (String s : split) {
                if (Objects.equals(s, temp)) {
                    times++;
                    if (times >= 3) {
                        if (Objects.equals(temp, "A")) {
                            index++;
                        } else {
                            index--;
                        }
                    }
                } else {
                    temp = s;
                    times = 1;
                }
            }
            return index > 0;
        } else {
            return false;
        }
    }

    /**
     * 两数字之和
     */
    public int[] twoSum(int[] nums, int target) {
        // 暴力循环
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target && i != j) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().winnerOfGame("AAABABB"));
//        System.out.println("AABB".length());
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
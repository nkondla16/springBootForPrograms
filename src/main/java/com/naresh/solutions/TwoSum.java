package com.naresh.solutions;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import  java.util.ArrayList;

public class TwoSum {

    public static void main(String[] args) {

        Integer[] nums = {21, 17, 4, 3, 2, 5, 7};

        Integer[] result = twoSum(nums, 9);

        List<Integer> res = new ArrayList<>(Arrays.asList(result));

        res.forEach(System.out::println);

    }

    public static Integer[] twoSum(Integer[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new Integer[]{map.get(complement), i};
            }
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/*
One-pass Hash Table
It turns out we can do it in one-pass. While we iterate and inserting elements into the table,
we also look back to check if current element's complement already exists in the table. If it exists,
 we have found a solution and return immediately.

Complexity Analysis:
Time complexity : O(n)O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.
Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
 */

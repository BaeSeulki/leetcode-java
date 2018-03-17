package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * 数组中找两个数，使它们的和为特定数
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 * Created by zhouyu on 2017/11/6.
 */
public class Two_Sum
{
    class Solution {
        //time：O(n^2)=53 ms  space：O(1)
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            int lenth_nums = nums.length;
            for (int i = 0; i<lenth_nums; i++) {
                for(int j= i+1; j<lenth_nums; j++){
                    if(nums[i]+nums[j] == target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                        //return new int[] { i, j };
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        // other methods: hash table
        // time：O(n)= 10ms  space：O(n)
        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(); // 先建立 数值-索引 哈希表
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        // time：O(n)= 8ms  space：O(n)
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            // 同时查找和建立哈希表
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        Two_Sum two_sum = new Two_Sum();

        Two_Sum.Solution solution = two_sum.new Solution(); // 调用内部类
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
        System.out.println(Arrays.toString(solution.twoSum1(nums, target)));
        System.out.println(Arrays.toString(solution.twoSum2(nums, target)));

    }
}

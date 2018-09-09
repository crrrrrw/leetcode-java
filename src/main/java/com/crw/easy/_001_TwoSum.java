package com.crw.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 举例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class _001_TwoSum {

    /**
     * 思路：双遍历
     * 1.从头遍历所有元素
     * 2.每次遍历从此元素的剩下的元素中查找匹配
     * <p>
     * 时间复杂度：O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 思路：空间换时间
     * 1.用map存储，k->target-当前值，v->当前索引
     * 2.一层循环查找，值为与map中的key相同的索引。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 24, 10, 7, 30};
        _001_TwoSum obj = new _001_TwoSum();
        for (int anInt : obj.twoSum1(nums, 15)) {
            System.out.print(anInt + " ");
        }
        for (int anInt : obj.twoSum2(nums, 15)) {
            System.out.print(anInt + " ");
        }
    }

}

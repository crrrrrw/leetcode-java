package com.crw.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 示例1：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 示例2：
 * 给定数组 nums = [-1,0,-5,-2,-2,-4,0,1,-2],和 target = -9.
 * [
 * [-5,-4,-1,1],
 * [-5,-4,0,0],
 * [-5,-2,-2,0],
 * [-4,-2,-2,-1]
 * ]
 */
public class _018_FourSum {

    public static void main(String[] args) {
        fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9).forEach(System.out::println);
    }

    /**
     * 和 3sum基本思路差不多，只不过变成固定 2 个数，剩下 2 个数用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 固定第 1 个数 i
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 第1个数去重


            // 固定第 2 个数 j
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 第2个数去重

                // 第 3、4个数用双指针
                int l = j + 1, r = nums.length - 1;

                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 左右指针分别右、左移，并且去重
                        while (l < r && nums[r] == nums[--r]) ;
                        while (l < r && nums[l] == nums[++l]) ;
                    } else if (sum > target) {
                        // 右指针左移，并且去重
                        while (l < r && nums[r] == nums[--r]) ;
                    } else {
                        // 左指针右移，并且去重
                        while (l < r && nums[l] == nums[++l]) ;
                    }
                }


            }

        }


        return result;
    }
}

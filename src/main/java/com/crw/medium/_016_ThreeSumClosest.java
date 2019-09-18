package com.crw.medium;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class _016_ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, 4}, 1));
    }

    /**
     * 还是双指针
     * 相较于 3sum，这里需要存储绝对值最小的 int[] 和 最接近的值
     *
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);

        // 前三个数直接就等于 target
        if (diff == 0) return closest;

        // 共需查找n-2次
        for (int i = 0; i < nums.length - 2; i++) {

            // 双指针 l r
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                int curDiff = Math.abs(sum - target);

                // 新的值等于 target 直接返回
                if (curDiff == 0) return target;

                // 更接近，更新值
                if (curDiff < diff) {
                    closest = sum;
                    diff = curDiff;
                }

                // 移动双指针
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }

            }


        }

        return closest;
    }

}

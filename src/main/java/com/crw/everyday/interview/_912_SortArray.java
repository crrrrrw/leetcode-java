package com.crw.everyday.interview;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class _912_SortArray {

    public static void main(String[] args) {
        int[] nums = sortArray(new int[]{5, 1, 1, 2, 0, 0});
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 快排
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int j = partition(nums, start, end);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    private static int partition(int[] nums, int left, int right) {
        int base = nums[left];
        int i = left;
        int j = right + 1;

        while (true) {
            while (base <= nums[--j] && j != left) ;
            while (base >= nums[++i] && i != right) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}

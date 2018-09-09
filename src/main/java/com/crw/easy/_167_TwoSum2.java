package com.crw.easy;

/**
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class _167_TwoSum2 {

    /**
     * 思路：双指针
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 1.如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 2.如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 3.如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;

            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 7, 10, 16, 24, 30};
        _167_TwoSum2 obj = new _167_TwoSum2();
        for (int anInt : obj.twoSum(nums, 15)) {
            System.out.print(anInt + " ");
        }
    }
}

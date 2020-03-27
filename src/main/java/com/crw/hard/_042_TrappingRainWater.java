package com.crw.hard;

/**
 * 42.接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class _042_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{2, 0, 2}));
    }

    /**
     * 思路：对于每根柱子，找到其左边的最大值，右边的最大值，然后两者中的较小的减去本根柱子的高度，就是本根柱子上能存放的雨水。
     * 比如 7 4 5 6
     * 因为7是最左边的数，因此，本根柱子能存放的雨水为0，
     * 对于4，其左边的最大值为7，右边的最大值为6.本根柱子能存放的雨水为min(7,6) - 4 = 2
     * 对于5，其左边的最大值为7，右边的最大值为6.本根柱子能存放的雨水为min(7,6) - 1 = 1
     * 因为6是最右边的数，因此，本根柱子能存放的雨水为0。
     * 因此我们可以建两个数组left[]用来存放某个位置左边的最大值、right[]用来存放某个位置右边的最大值
     * min(left[i],right[i]) - height[i]就是本位置能存放雨水的值。
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        // leftMax,rightMax分别存储第 i 个位置的左边的最大值和右边的最大值
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];

        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = leftMax[i - 1] > height[i] ? leftMax[i - 1] : height[i];
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = rightMax[i + 1] > height[i] ? rightMax[i + 1] : height[i];
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];

        }

        return result;
    }
}

package com.crw.medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2
 * <p>
 * 示例：
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class _011_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /**
     * 双指针法
     * 1.双指针分别指向头尾
     * 2.计算i-j范围内的面积，底=j-i，高=min{height[i],height[j]}
     * 3.移位 i 和 j 中较低的位置，循环 2，3步骤
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int curArea = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, curArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}

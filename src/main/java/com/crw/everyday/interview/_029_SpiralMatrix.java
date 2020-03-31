package com.crw.everyday.interview;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class _029_SpiralMatrix {

    public static void main(String[] args) {
        int[] arr = spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return new int[0];

        int l = 0; // 左边界索引
        int r = matrix[0].length - 1; // 右边界索引
        int t = 0;// 上边界索引
        int b = matrix.length - 1;// 底部边界索引
        int[] ans = new int[(r + 1) * (b + 1)];
        int idx = 0;
        while (l <= r && t <= b) {
            // 打印上层，从左到右
            for (int i = l; i <= r && t <= b; i++, idx++) {
                ans[idx] = matrix[t][i];
            }
            t++;
            // 打印右层，从上到下
            for (int i = t; i <= b && l <= r; i++, idx++) {
                ans[idx] = matrix[i][r];
            }
            r--;
            // 打印底层，从右到左
            for (int i = r; i >= l && t <= b; i--, idx++) {
                ans[idx] = matrix[b][i];

            }
            b--;
            // 打印左层，从下到上
            for (int i = b; i >= t && l <= r; i--, idx++) {
                ans[idx] = matrix[i][l];
            }
            l++;

        }

        return ans;
    }
}

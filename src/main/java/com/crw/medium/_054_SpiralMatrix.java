package com.crw.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _054_SpiralMatrix {

    public static void main(String[] args) {
//        System.out.println(spiralOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        }));

        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }

    /**
     * 4个边界：l,r,t,b
     * 模拟旋转打印
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix == null || matrix.length == 0)
            return ans;

        int l = 0; // 左边界索引
        int r = matrix[0].length - 1; // 右边界索引
        int t = 0;// 上边界索引
        int b = matrix.length - 1;// 底部边界索引
        while (l <= r && t <= b) {
            // 打印上层，从左到右
            for (int i = l; i <= r && t <= b; i++) {
                ans.add(matrix[t][i]);
            }
            t++;
            // 打印右层，从上到下
            for (int i = t; i <= b && l <= r; i++) {
                ans.add(matrix[i][r]);
            }
            r--;
            // 打印底层，从右到左
            for (int i = r; i >= l && t <= b; i--) {
                ans.add(matrix[b][i]);

            }
            b--;
            // 打印左层，从下到上
            for (int i = b; i >= t && l <= r; i--) {
                ans.add(matrix[i][l]);
            }
            l++;

        }

        return ans;
    }
}

package com.crw.everyday.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _057_ll_FindContinuousSequence {

    public static void main(String[] args) {
        int[][] arr = findContinuousSequence(15);
        for (int[] ints : arr) {
            System.out.println();
            for (int i : ints) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 滑动窗口
     * 根据 sum 值更改窗口的大小，初始都从1开始
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1; // 左边界
        int r = 1; // 右边界
        int sum = 0;
        while (l < (target / 2 + 1)) {
            if (sum == target) {
                // 找到并记录
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                res.add(arr);
                sum -= l;
                l++;
            } else if (sum < target) {
                // 扩大窗口
                sum += r;
                r++;
            } else {
                // 缩小窗口
                sum -= l;
                l++;
            }
        }

        return res.toArray(new int[res.size()][]);

    }

}

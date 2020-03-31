package com.crw.everyday.interview;

import java.util.PriorityQueue;

/**
 * 面试题40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _40_GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = getLeastNumbers(new int[]{6, 8, 4, 3, 2, 1}, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * TopK 问题，堆排序最好想到
     * <p>
     * 1. 维护一个容量为 k 的大根堆。
     * 2. 遍历数组
     * - 若堆不足k，直接进堆
     * - 若元素大于根，跳过，否则，弹出堆顶，元素入堆
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 默认小跟堆，通过构造器改为大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        // 返回堆中的元素
        int[] res = new int[queue.size()];
        for (int i = queue.size() - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;

    }

}

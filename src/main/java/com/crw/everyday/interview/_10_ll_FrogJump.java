package com.crw.everyday.interview;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 提示：
 * 0 <= n <= 100
 * <p>
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _10_ll_FrogJump {

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     * <p>
     * 考虑到 f[n] 只与 df[n - 1] 和 f[n - 2] 有关，
     * 因此可以只用两个变量来存储 f[n - 1] 和 f[n - 2]，使得原来的 O(N) 空间复杂度优化为 O(1) 复杂度。
     *
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n <= 2) return n;

        int f1 = 1, f2 = 2, cur;
        for (int i = 2; i < n; i++) {
            cur = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = cur;
        }

        return f2;
    }
}

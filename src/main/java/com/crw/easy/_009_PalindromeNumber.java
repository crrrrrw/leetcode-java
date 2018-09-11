package com.crw.easy;

/**
 * 回文数
 * 描述：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例1：
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class _009_PalindromeNumber {

    /**
     * 思路1：直接计算出这个数的回文数，再比较即可
     * 1.如果此数为负数，直接返回false
     * <p>
     * 问题：精度问题，这个数的回文数可能整数溢出。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int rev = 0, x2 = x;
        while (x2 != 0) {
            int pop = x2 % 10; // 弹出的值
            rev = rev * 10 + pop;
            x2 /= 10;
        }
        return x == rev;
    }

    /**
     * 思路2：反转一半的数，反转后半部分的数，与前半部分比较
     * 1. 如何计算何时为一半的数？每次除10，直到反转的数不小于剩下的数为止。
     * 2. 10的倍数的问题，比如 10010，还是会返回true，但实际上为false。
     * 解决，当 x % 10 == 0时，也返回false
     * 3. 考虑奇数位，比如 12321，最后会达到 x = 12,rev = 123, 当 rev / 10 == x 时也返回true即可
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        _009_PalindromeNumber obj = new _009_PalindromeNumber();
        System.out.println(obj.isPalindrome1(12321));
        System.out.println(obj.isPalindrome2(12321));
    }

}

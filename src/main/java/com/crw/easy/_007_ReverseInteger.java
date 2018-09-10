package com.crw.easy;

/**
 * 描述：
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例1：
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class _007_ReverseInteger {

    /**
     * 思路:
     * 类似栈模型，每次取模10获取末尾的值弹出，然后将此值推入新的结果值。
     * 需要考虑溢出的情况,精度需要更大，用long
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10; // 弹出的值
            rev = rev * 10 + pop;
            x /= 10;
        }

        return rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ? 0 : (int) rev;
    }

    public static void main(String[] args) {
        _007_ReverseInteger obj = new _007_ReverseInteger();
        System.out.println(obj.reverse(123));
        System.out.println(obj.reverse(-313234));
        System.out.println(obj.reverse(Integer.MAX_VALUE));
        System.out.println(obj.reverse(Integer.MIN_VALUE));
    }

}

package com.crw.everyday.interview;

/**
 * 面试题62. 圆圈中最后剩下的数字
 * <p>
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _062_JosephusLoop {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
    }

    /**
     * 约瑟夫环问题，由于性能问题，不能简单实用循环链表处理，否则通过不了，采用数学法。
     * <p>
     * pn = (pn-1 + m) % i
     * i:剩余人数，m:第m个出列的元素，p:当前索引
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n == 0 || n == 1) return n;
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p;
    }


}

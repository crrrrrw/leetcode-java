package com.crw.medium;

/**
 * 描述：
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _002_AddTwoNumbers {

    /**
     * 单向链表
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：
     * 等同于初等数学相加进位情况。
     * <p>
     * 需要考虑多种情况：
     * 1.一个列表比另一个列表长时。
     * 2.一个列表为空时
     * 3.求和运算额外进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0); // 初始化列表哑节点
        ListNode p = l1, q = l2, current = node;
        int sum = 0; // 当前总值

        while (p != null || q != null) {
            sum /= 10; // 进位，为1或者0
            // 当链表还有值时，处理 sum和指向下一节点
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            current.next = new ListNode(sum % 10); // 下一节点赋值
            current = current.next;
        }
        // 处理情况3，循环完还要进1位的情况
        if (sum / 10 > 0) {
            current.next = new ListNode(1);
        }
        return node.next;
    }
}

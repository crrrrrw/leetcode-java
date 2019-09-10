package com.crw.medium;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class _092_ReverseLinkedList_II {

    public static void main(String[] args) {

        ListNode node = ListNodeUtil.createListNode();
        node = reverseBetween(node, 3, 6);
        ListNodeUtil.print(node);
    }

    /**
     * 1->2->3->4->5, m = 2, n=4
     * - 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * - 当前节点的下一个节点3调整为前驱节点的下一个节点：1->3->2->4->5,
     * - 当前结点仍为2， 前驱结点依然是1，重复上一步操作
     * - 1->4->3->2->5.
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        // 无需操作
        if (m == n) {
            return head;
        }

        // 辅助节点，存储最初的头节点位置
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 前驱节点
        ListNode pre = dummy;

        // 前 m-1 个元素无须处理，直接遍历。定位到前驱节点，即需要开始反转节点的前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // 定位到反转部分的头节点
        head = pre.next;

        // 开始反转节点
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next; // 修改当前节点指针
            next.next = pre.next; // 修改next节点指针
            pre.next = next; // 修改前驱节点指针
        }

        return dummy.next;
    }
}

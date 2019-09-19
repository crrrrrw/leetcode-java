package com.crw.medium;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class _024_SwapPairs {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode();
        ListNodeUtil.print(swapPairs(listNode));
    }

    /**
     * 迭代法。画好图避免写错
     * <p>
     * 需要一个辅助节点指向当前操作节点。
     * 以下下简称 辅助节点prev为 0 号节点，当前节点为 1 号节点，当前节点下一节点为 2 好节点。
     * <p>
     * 初始：1 2 3 4
     * <p>
     * 第一次:
     * 0->2
     * 1->3
     * 2->1
     * <p>
     * 变成：
     * 2 1 3 4
     * <p>
     * 然后把 prev 指向 1 重复即可
     *
     * @param head
     * @return
     */
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode ans = head.next;
        // 辅助节点，当前节点的前一个.(0号节点)
        ListNode prev = new ListNode(-1);
        prev.next = head;
        // 当前节点（1号节点）和 后一节点（2号节点）
        while (prev.next != null && prev.next.next != null) {
            // 1号节点 和 2号节点
            ListNode n1 = prev.next, n2 = prev.next.next;
            // 0->2
            prev.next = n2;
            // 1->3
            n1.next = n2.next;
            // 2->1
            n2.next = n1;

            // 0->1
            prev = n1;
        }

        return ans;
    }
}

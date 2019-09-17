package com.crw.medium;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 删除链表的倒数第N个节点.
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class _019_RemoveNthFromEnd {


    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode();
        ListNodeUtil.print(removeNthFromEnd(listNode, 2));
    }

    /**
     * 通过 2 个指针
     * cur指针先走 n 步。
     * 若此时 cur.next为空，则 n 为链表长度，则结果值就是头结点。
     * 若此时 cur.next存在，则 pre 指向头结点， cur和pre指针同时移动，
     * 直到 cur 走到链尾，则此时pre指针指向的位置即为倒数n节点。
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head, pre;
        // cur 移动到第 n 个节点
        while (cur.next != null && --n > 0) cur = cur.next;

        // n 为链表长度，删除头节点即可
        if (cur.next == null) return head.next;

        cur = cur.next;
        pre = head;
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        // 此时 pre 节点是倒数第 n+1 个节点，现在删除 pre.next 即可
        pre.next = pre.next.next;

        return head;
    }
}

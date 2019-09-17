package com.crw.easy;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 删除排序链表中的重复元素
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class _083_DeleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode();
        ListNodeUtil.print(deleteDuplicates(listNode));
    }

    /**
     * 非递归版本
     *
     * @param head
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }


    /**
     * 递归
     * 代码量较多版，每次返回比对的
     *
     * @param head
     * @return
     */
    private static ListNode deleteDuplicates3(ListNode head) {
        ListNode ans = head;
        deleteDuplicatesHelper(head);
        return ans;
    }

    private static ListNode deleteDuplicatesHelper(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val == head.next.val) {
            head.next = head.next.next;
            head = deleteDuplicatesHelper(head);
        } else {
            head = deleteDuplicatesHelper(head.next);
        }

        return head;
    }

}

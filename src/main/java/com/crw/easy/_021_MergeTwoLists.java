package com.crw.easy;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _021_MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtil.createListNode();
        ListNode l2 = ListNodeUtil.createListNode();
        ListNodeUtil.print(mergeTwoLists(l1, l2));
    }

    /**
     * 递归，算法比较简单，不解释了
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

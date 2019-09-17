package com.crw.hard;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class _023_MergeKLists {


    public static void main(String[] args) {
        ListNodeUtil.print(mergeKLists(new ListNode[]{
                ListNodeUtil.createListNode(),
                ListNodeUtil.createListNode(),
                ListNodeUtil.createListNode(),
                ListNodeUtil.createListNode(),
                ListNodeUtil.createListNode()}
        ));
    }

    /**
     * 分治思想
     * <p>
     * 转化为两两合并。
     * 每次从中间分隔成2份，然后各半部分分别递归分隔，分到只有2个链表时，再合
     * 每次合并2个链表为1个链表，直到所有链表合为1个
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKLists(ListNode[] lists) {
        return mergeKhelper(lists, 0, lists.length - 1);
    }


    private static ListNode mergeKhelper(ListNode[] lists, int left, int right) {
        if (left > right) return null;

        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;

        ListNode l1 = mergeKhelper(lists, left, mid);
        ListNode l2 = mergeKhelper(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    /**
     * 合并2个有序链表
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

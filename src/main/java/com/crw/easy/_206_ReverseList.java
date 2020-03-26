package com.crw.easy;

import com.crw.common.ListNode;
import com.crw.common.ListNodeUtil;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _206_ReverseList {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.createListNode();
        node = reverseList(node);
        ListNodeUtil.print(node);

        ListNode node2 = ListNodeUtil.createListNode();
        node2 = reverseList2(node2);
        ListNodeUtil.print(node2);

    }

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }


    /**
     * 尾递归法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        return reverse(prev, curr);

    }

    private static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) return prev;
        ListNode next = cur.next;
        cur.next = prev;
        return reverse(cur, next);
    }

}

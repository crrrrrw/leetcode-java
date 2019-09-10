package com.crw.common;

import java.util.Scanner;

public class ListNodeUtil {

    public static void main(String[] args) {
        ListNode listNode = createListNode();
        print(listNode);

    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * 头插法创建
     * 倒序拆入
     *
     * @return
     */
    public static ListNode createListNodeReverse() {
        ListNode head = new ListNode(-1);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if ("q".equals(value)) {
                scanner.close();
                return head;
            }
            ListNode newNode = new ListNode(Integer.valueOf(value));
            if (head.next == null) {
                head.next = newNode;
            } else {
                newNode.next = head.next;
                head.next = newNode;
            }
        }

        return head;
    }

    /**
     * 尾插法创建
     * 顺序插入
     *
     * @return
     */
    public static ListNode createListNode() {
        ListNode tail = new ListNode(-1);
        ListNode result = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if ("q".equals(value)) {
                scanner.close();
                return result;
            }
            ListNode newNode = new ListNode(Integer.valueOf(value));
            if (tail.next == null) {
                result = newNode;
            } else {
                tail.next.next = newNode;
            }
            tail.next = newNode;
        }

        return result;
    }
}


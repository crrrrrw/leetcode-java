package com.crw.common;

import java.util.Scanner;

public class LinkedNodeUtil {

    public static void main(String[] args) {
        LinkedNode linkedNode = createLinkedNode();
        print(linkedNode);

    }

    static void print(LinkedNode linkedNode) {
        while (linkedNode != null) {
            System.out.print(linkedNode.val + " ");
            linkedNode = linkedNode.next;
        }
    }

    /**
     * 头插法创建
     * 倒序拆入
     *
     * @return
     */
    static LinkedNode createLinkedNodeReverse() {
        LinkedNode head = new LinkedNode(-1);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if ("q".equals(value)) {
                scanner.close();
                return head;
            }
            LinkedNode newNode = new LinkedNode(Integer.valueOf(value));
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
    static LinkedNode createLinkedNode() {
        LinkedNode tail = new LinkedNode(-1);
        LinkedNode result = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if ("q".equals(value)) {
                scanner.close();
                return result;
            }
            LinkedNode newNode = new LinkedNode(Integer.valueOf(value));
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


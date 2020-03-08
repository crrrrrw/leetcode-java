package com.crw.common;

public class TreeNodeUtil {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        printTreeBinary(arrToTree(arr));
    }

    public static TreeNode arrToTree(int[] arr) {
        return arrToTree(arr, 0);
    }

    private static TreeNode arrToTree(int[] arr, int index) {
        TreeNode root = null;
        if (index < arr.length) {
            int value = arr[index];
            root = new TreeNode(value);
            root.left = arrToTree(arr, 2 * index + 1);
            root.right = arrToTree(arr, 2 * index + 2);
            return root;
        }
        return root;
    }

    /**
     * 前序遍历
     */
    public static void printTreeBinary(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            printTreeBinary(treeNode.left);
            printTreeBinary(treeNode.right);
        }
    }
}

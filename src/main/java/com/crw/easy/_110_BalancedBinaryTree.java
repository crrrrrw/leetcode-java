package com.crw.easy;

import com.crw.common.TreeNode;
import com.crw.common.TreeNodeUtil;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _110_BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(
                isBalanced(
                        TreeNodeUtil.arrToTree(new int[]{3, 9, 20, 0, 0, 15, 7})
                )
        );
        System.out.println(
                isBalanced(
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 2, 3, 3, 0, 0, 4, 4})
                )
        );
    }


    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    /**
     * 递归求树高，若不平衡返回 -1
     *
     * @param root
     * @return
     */
    private static int depth(TreeNode root) {
        if (root == null)
            return 0;
        int l = depth(root.left);
        if (l == -1) return -1;
        int r = depth(root.right);
        if (r == -1) return -1;

        if (l != -1 && r != -1 && Math.abs(l - r) <= 1) {
            return Math.max(l, r) + 1;
        } else {
            return -1;
        }
    }
}

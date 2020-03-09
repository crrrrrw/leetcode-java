package com.crw.easy;

import com.crw.common.TreeNode;
import com.crw.common.TreeNodeUtil;
import com.sun.org.apache.regexp.internal.REUtil;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(
                minDepth(
                        TreeNodeUtil.arrToTree(new int[]{3, 9, 20, 0, 0, 15, 7})
                )
        );
    }

    /**
     * 与最大深度正好相反
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}

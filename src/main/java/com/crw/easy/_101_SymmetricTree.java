package com.crw.easy;

import com.crw.common.TreeNode;
import com.crw.common.TreeNodeUtil;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _101_SymmetricTree {


    public static void main(String[] args) {
        System.out.println(
                isSymmetric(
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 2, 3, 4, 4, 3})
                )
        );

        System.out.println(
                isSymmetric(
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 2, 0, 3, 0, 3})
                )
        );
    }

    /**
     * 简单，与 _100_IsSameTree 类似
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}

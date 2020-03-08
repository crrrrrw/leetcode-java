package com.crw.easy;

import com.crw.common.TreeNode;
import com.crw.common.TreeNodeUtil;
import com.sun.org.apache.regexp.internal.REUtil;

/**
 * 问：
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 1          1
 * /            \
 * 2              2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入:
 * 1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _100_IsSameTree {

    public static void main(String[] args) {
        System.out.println(
                isSameTree(
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 3}),
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 3})
                )
        );

        System.out.println(
                isSameTree(
                        TreeNodeUtil.arrToTree(new int[]{1, 2}),
                        TreeNodeUtil.arrToTree(new int[]{1, 0, 2})
                )
        );

        System.out.println(
                isSameTree(
                        TreeNodeUtil.arrToTree(new int[]{1, 2, 1}),
                        TreeNodeUtil.arrToTree(new int[]{1, 1, 2})
                )
        );
    }


    /**
     * 很简单，递归思想
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


}

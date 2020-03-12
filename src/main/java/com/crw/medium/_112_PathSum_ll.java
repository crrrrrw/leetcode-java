package com.crw.medium;

import com.crw.common.TreeNode;
import com.crw.common.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _112_PathSum_ll {

    public static void main(String[] args) {
        System.out.println(
                hasPathSum(
                        TreeNodeUtil.arrToTree(new int[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1}), 22
                )
        );
    }

    static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        if (root == null) return result;
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path);
        return result;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(path));
        }
        // 未找到需删除这个值，重新找
        path.remove(path.size() - 1);
    }

}


package LeetCode.TreeOperation;

import LeetCode.TreeOperation.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */

public class All_Nodes_Distance_K_in_Binary_Tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        help(root, target, res, K);
        return res;
    }
    private int help(TreeNode root, TreeNode target, List<Integer> res, int K) {
        if(root == null) return -1;
        if(root == target) {
            distance(root, res, K);
        }

        int l = help(root.left, target, res, K);
        int r = help(root.right, target, res, K);

        if(l != -1) {   // 如果target在root的左子树上
            if(l + 1 == K) {
                res.add(root.val);
            } else {
                distance(root.left, res, K - l -2);
            }
            return l + 1;
        }

        if(r != -1) {   // 如果target在root的右子树上
            if(r + 1 == K) {
                res.add(root.val);
            } else {
                distance(root.right, res, K - r -2);
            }
            return r + 1;
        }
        return -1;
    }

    private void distance(TreeNode root, List<Integer> res, int k) {
        if(root == null) return;
        if(k == 0) {
            res.add(root.val);
            return;
        }
        distance(root.left, res, k - 1);
        distance(root.right, res, k -1);
    }
}

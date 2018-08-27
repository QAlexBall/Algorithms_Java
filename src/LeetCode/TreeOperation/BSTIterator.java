package LeetCode.TreeOperation;

import edu.princeton.cs.algs4.Stack;

public class BSTIterator {

    /**
     * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
     * 调用 next() 将返回二叉搜索树中的下一个最小的数。
     * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
     */
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next  smallest number */
    public int next() {
        TreeNode next = stack.pop();
        TreeNode current = next.right;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        return next.val;
    }
}

package LeetCode;

public class BST_Operation {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树.
     *
     * @param root;
     * @return true or false;
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }


    private TreeNode pre;
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean f = isValidBST(root.left);
        boolean f2 = pre == null || pre.val < root.val;
        pre = root;
        return f && f2 && isValidBST(root.right);
    }
}

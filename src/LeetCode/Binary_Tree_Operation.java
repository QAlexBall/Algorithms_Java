package LeetCode;

import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;
import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.*;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Binary_Tree_Operation {
    // 中序遍历二叉树
    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder_helper(root, list);
        return list;
    }
    private void inorder_helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder_helper(root.left, list);
            System.out.println(root.val);
            list.add(root.val);
            if (root.right != null) inorder_helper(root.right, list);
        }
    }
    // 中序遍历(栈)
    private List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    // 按层添加节点
    private void ComputeEveryLevelSize(ArrayDeque<TreeNode> queue, int levelSize, List<Integer> levelList) {
        TreeNode root;
        for(int i = 0; i < levelSize; i++) {
            root = queue.removeLast();
            levelList.add(root.val);
            if(root.left != null) queue.addFirst(root.left);
            if(root.right != null) queue.addFirst(root.right);
        }
    }
    // 前层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return list;
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            ComputeEveryLevelSize((ArrayDeque<TreeNode>) queue, levelSize, levelList);
            list.add(levelList);
        }
        return list;
    }
    // 后层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return list;
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            ComputeEveryLevelSize((ArrayDeque<TreeNode>) queue, levelSize, levelList);
            list.add(0, levelList);
        }
        return list;
    }

    /* 二叉树最大深度 */
    // 自顶向下(Top-down)
    private int answer;		// don't forget to initialize answer before call maximum_depth
    public int maxDepthTop2Down(TreeNode root) {
        answer = 0;
        int depth = 1;
        maximum_depth(root, depth);
        return answer;
    }
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    // 自底向上(Bottom-up)
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }


    /* 判断二叉树是否平衡 */
    // 后序遍历
    private boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        TreeDepth(root);
        return balance;
    }
    private int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        if(Math.abs(left - right) > 1) {
            balance = false;
        }
        return Math.max(left, right) + 1;
    }
    // 前序遍历
    public boolean isBalanced1(TreeNode root) {
        if(root == null) return true;	//空树是平衡二叉树
        //判断根节点的平衡因子是否大于1,或者小于1
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(Math.abs(rightDepth - leftDepth) > 1) {
            return false;
        } else {//如果根节点平衡因子正常,则判断它的左右结点是否为平衡二叉树
            return isBalanced1(root.left) && isBalanced1(root.right);
        }
    }
    private static int getDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 叶子相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    // 深度优先搜索
    private void dfs(TreeNode node, List<Integer> leafVal) {
        if(node != null) {
            if(node.left == null && node.right == null)
                leafVal.add(node.val);
            dfs(node.left, leafVal);
            dfs(node.right, leafVal);
        }
    }


    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root;
     * @param sum;
     * @return true or false;
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        if (root.left == null) return hasPathSum(root.right, sum-root.val);
        if (root.right == null) return hasPathSum(root.left, sum-root.val);
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     */
    public TreeNode buildTree(int[] inoder, int[] postorder) {
        TreeNode root = new TreeNode(0);
        return root;
    }

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();   // trim()           从当前 String 对象移除所有前导空白字符和尾部空白字符。
                                // trim(char[])     从当前 String 对象移除数组中指定的一组字符的所有前导匹配项和尾部匹配项。
        // input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    private static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    private static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        InputStream in1 = new FileInputStream("src/LeetCode/a.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(in1));
        String line;
//        while ((line = in.readLine()) != null) {
//            TreeNode root = stringToTreeNode(line);
//            List<Integer> ret = new Binary_Tree_Operation().inorderTraversal(root);
//            // String out = integerArrayListToString(ret);
//            // System.out.print(out);
//        }
        Binary_Tree_Operation bto = new Binary_Tree_Operation();

        TreeNode root = stringToTreeNode(line = in.readLine());
        BSTIterator bst = new BSTIterator(root);
        System.out.println(bst.hasNext());
        System.out.println(bst.next());

        List<Integer> ret = new Binary_Tree_Operation().inorderTraversal(root);
        // String out = integerArrayListToString(ret);
        System.out.println(ret);
        
        System.out.println(bto.maxDepthTop2Down(root));
    }
}

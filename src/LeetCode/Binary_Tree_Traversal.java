package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Binary_Tree_Traversal {
    private void inorder_helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder_helper(root.left, list);
            System.out.println(root.val);
            list.add(root.val);
            if (root.right != null) inorder_helper(root.right, list);
        }
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder_helper(root, list);
        return list;
    }
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

    private void ComputeEveryLevelSize(ArrayDeque<TreeNode> queue, int levelSize, List<Integer> levelList) {
        TreeNode root;
        for(int i = 0; i < levelSize; i++) {
            root = queue.removeLast();
            levelList.add(root.val);
            if(root.left != null) queue.addFirst(root.left);
            if(root.right != null) queue.addFirst(root.right);
        }
    }
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

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();   // trim()           从当前 String 对象移除所有前导空白字符和尾部空白字符。
                                // trim(char[])     从当前 String 对象移除数组中指定的一组字符的所有前导匹配项和尾部匹配项。
        input = input.substring(1, input.length() - 1);
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<Integer> ret = new Binary_Tree_Traversal().inorderTraversal(root);

            String out = integerArrayListToString(ret);
            System.out.print(out);
        }
    }
}

package LeetCode.TreeOperation.NArrayTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class NTTraversal {

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for(Node child : root.children) {
           res.addAll(preorder(child));
        }
    return res;
    }
    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        for(Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
        return res;
    }
}
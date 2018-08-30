package LeetCode.TreeOperation.NArrayTree;

public class NaryMaxDepth {
    public int maxDepth(Node root) {
        int depth = 0;
        if(root == null) return 0;
        if(root.children == null) return 1;
        for(Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Result {
    TreeNode node;
    int depth;

    Result(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaHelper(root).node;
    }

    private Result lcaHelper(TreeNode root) {
        if (root == null)
            return new Result(null, 0);

        Result left = lcaHelper(root.left);
        Result right = lcaHelper(root.right);

        if (left.depth > right.depth)
            return new Result(left.node, left.depth + 1);
        else if (left.depth < right.depth)
            return new Result(right.node, right.depth + 1);
        else
            return new Result(root, left.depth + 1);
    }
}

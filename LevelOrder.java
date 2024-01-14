/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class Pair {
        TreeNode treeNode;
        int level;
        Pair(TreeNode treeNode,int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(root!=null && !queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int level = queue.peek().level;
            while(!queue.isEmpty() && level==queue.peek().level) {
                Pair p = queue.poll();
                list.add(p.treeNode.val);
                if(p.treeNode.left!=null) queue.add(new Pair(p.treeNode.left,p.level+1));
                if(p.treeNode.right!=null) queue.add(new Pair(p.treeNode.right,p.level+1));
            }
            ans.add(list);
        }
        return ans;
    }
}

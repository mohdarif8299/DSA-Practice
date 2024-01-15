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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        boolean level = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count=-1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size && !queue.isEmpty();i++) {
                TreeNode node = queue.poll();
                list.add(node.val);    
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
            }
            
            if(count%2==0) {
                result.add(new ArrayList<>(list));
            } else {
                Collections.reverse(list);
                result.add(new ArrayList<>(list));
            }
        }
        return result;
    }
}

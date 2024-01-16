class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Main {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(26);
        TreeNode left = new TreeNode(10);
        TreeNode leftRight = new TreeNode(6);
        TreeNode leftLeft = new TreeNode(4);
        
        TreeNode right = new TreeNode(3);
        TreeNode rightRight = new TreeNode(3);
        
        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;
        root.right.right = rightRight;
        
        
        //inOrder(root);
        
        
        System.out.println(sumTree(root) == 2*root.val);
    }
    
    public static int sumTree(TreeNode root) {
        if(root == null) return 0;
        int sum = root.val + sumTree(root.left) + sumTree(root.right);
        return sum;
    }
    
    public static void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }
}

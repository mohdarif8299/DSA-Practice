class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class Main {
    static int floor = -1, ceil = -1;
    
    public static void findFloorCeil(TreeNode root, int target) {
        while(root != null) {
            if(root.value == target) {
               floor = target;
               ceil = target;
            } else if(root.value > target) {
                ceil = root.value;
                root = root.left;
            } else {
                floor = root.value;
                root = root.right;
            }
        }
    }
    public static void main(String args[]) {
         // Example BST:
        //        8
        //       / \
        //      3   12
        //     / \   \
        //    1   6   14

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(19);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(100);

        int targetValue = 11;

        
        findFloorCeil(root, targetValue);

        System.out.println("Floor of " + targetValue + ": " + floor);
        System.out.println("Ceil of " + targetValue + ": " + ceil);
    }
}

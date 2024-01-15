import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Using a TreeMap to automatically sort by key (column index)
        Map<Integer, List<int[]>> columnMap = new TreeMap<>();

        // Queues for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        Queue<Integer> rowQueue = new LinkedList<>();

        queue.offer(root);
        colQueue.offer(0);
        rowQueue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, PriorityQueue<int[]>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int col = colQueue.poll();
                int row = rowQueue.poll();

                // Store row and value as an array
                levelMap.computeIfAbsent(col, k -> new PriorityQueue<>(
                    (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])))
                    .add(new int[]{row, node.val});

                if (node.left != null) {
                    queue.offer(node.left);
                    colQueue.offer(col - 1);
                    rowQueue.offer(row + 1);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    colQueue.offer(col + 1);
                    rowQueue.offer(row + 1);
                }
            }

            for (Map.Entry<Integer, PriorityQueue<int[]>> entry : levelMap.entrySet()) {
                int col = entry.getKey();
                PriorityQueue<int[]> values = entry.getValue();
                List<int[]> colValues = columnMap.computeIfAbsent(col, k -> new ArrayList<>());
                while (!values.isEmpty()) {
                    colValues.add(values.poll());
                }
            }
        }

        for (List<int[]> colValues : columnMap.values()) {
            List<Integer> sortedColumn = colValues.stream()
                .map(arr -> arr[1])
                .collect(Collectors.toList());
            result.add(sortedColumn);
        }

        return result;
    }
}

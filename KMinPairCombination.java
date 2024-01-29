import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (A.length == 0 || B.length == 0 || k == 0) {
            return ans;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(A[a[0]] + B[a[1]], A[b[0]] + B[b[1]]));

        for (int i = 0; i < Math.min(k, A.length); i++) {
            priorityQueue.add(new int[]{i, 0});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] indices = priorityQueue.poll();
            ans.add(Arrays.asList(A[indices[0]], B[indices[1]]));

            if (indices[1] < B.length - 1) {
                priorityQueue.add(new int[]{indices[0], indices[1] + 1});
            }
        }

        return ans;
    }
}

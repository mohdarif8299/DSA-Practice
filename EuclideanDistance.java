class Solution {
    public static class Pair {
        int point_index;
        long euclidean_distance;
        Pair(int point_index,long euclidean_distance) {
            this.point_index = point_index;
            this.euclidean_distance =euclidean_distance ;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1.euclidean_distance > p2.euclidean_distance)
                return 1;
            else if (p1.euclidean_distance < p2.euclidean_distance)
                return -1;
            else
                return 0;
        });

        for (int i = 0; i < points.length; i++) {
            long euclidean_distance = 1L * (points[i][0] * 1L * points[i][0]) + 1L * (points[i][1] * 1L * points[i][1]);
            Pair p = new Pair(i, euclidean_distance);
            heap.offer(p);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair p = heap.peek();
            ans[i] = points[p.point_index];
            heap.poll();
        }

        return ans;
    }
}

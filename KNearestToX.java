class Solution {
    public static class Pair implements Comparable<Pair>{
        int diff;
        int value;
        Pair(int diff, int val) {
            this.diff = diff;
            this.value = val;
        }
        
        public int compareTo(Pair pair) {
            if (this.diff < pair.diff)
                return -1;
            else if (this.diff > pair.diff)
                return 1;
            else 
                return Integer.compare(this.value, pair.value);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++) {
            pq.add(new Pair(Math.abs(x-arr[i]), arr[i]));
        }


        List<Integer> list = new ArrayList<>();
        while(k-- >0 && !pq.isEmpty()) {
            list.add(pq.poll().value);
        }

        Collections.sort(list);
        return list; 
    }
}

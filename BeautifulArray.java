class Solution {
    public int[] beautifulArray(int N) {
         List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < N) {
            List<Integer> temp = new ArrayList<>();
            for (int num : result) {
                if (num * 2 - 1 <= N) {
                    temp.add(num * 2 - 1);
                }
            }
            for (int num : result) {
                if (num * 2 <= N) {
                    temp.add(num * 2);
                }
            }
            result = temp;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int n = arr.length;
        int[] xorPrefix = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            xorPrefix[i + 1] = xorPrefix[i] ^ arr[i];
        }
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = xorPrefix[left] ^ xorPrefix[right + 1];
        }
        
        return result;
    }
}

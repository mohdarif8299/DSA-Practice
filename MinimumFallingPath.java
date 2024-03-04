class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = A[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][Math.max(0, j - 1)], Math.min(dp[i - 1][j], dp[i - 1][Math.min(n - 1, j + 1)]));
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        
        return minSum;
    }
}

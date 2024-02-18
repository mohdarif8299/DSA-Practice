class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {  
        int n = nums.length;
        int[] result = new int[n];
        
        int maxXor = (1 << maximumBit) - 1;
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = maxXor ^ xorSum;
            xorSum ^= nums[n - 1 - i];
        }
        
        return result;
    } 
}

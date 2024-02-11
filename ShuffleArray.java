class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[2 * n];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            shuffled[index++] = nums[i];
            shuffled[index++] = nums[n + i];
        }
        
        return shuffled;
    }
}

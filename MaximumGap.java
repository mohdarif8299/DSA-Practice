class Solution {
    public int maximumGap(int[] nums) {
         if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            maxGap = Math.max(maxGap, gap);
        }

        return maxGap;
    }
}

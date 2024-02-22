class Solution {
    public int[] singleNumber(int[] nums) {
         int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        int rightmostSetBit = 1;
        while ((rightmostSetBit & diff) == 0) {
            rightmostSetBit <<= 1;
        }
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int result = Math.min(n - left - 1, right);
        for (int i = 0; i <= left; i++) {
            if (arr[i] <= arr[right]) {
                result = Math.min(result, right - i - 1);
            } else if (right < n - 1) {
                right++;
            } else {
                break;
            }
        }
        
        return result;
    }
}

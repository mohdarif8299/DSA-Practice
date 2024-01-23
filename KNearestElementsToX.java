import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Find the closest index using binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Initialize two pointers
        int lo = left - 1, hi = left;
        while (hi - lo - 1 < k) {
            if (lo < 0) {
                hi++;
            } else if (hi >= n || Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) {
                lo--;
            } else {
                hi++;
            }
        }

        // Collect and return the k closest elements
        List<Integer> result = new ArrayList<>();
        for (int i = lo + 1; i < hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

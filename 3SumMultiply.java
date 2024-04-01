class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long mod = 1_000_000_007;
        long answer = 0;
        java.util.Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int T = target - arr[i];
            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                if (arr[j] + arr[k] < T) {
                    j++;
                } else if (arr[j] + arr[k] > T) {
                    k--;
                } else { 
                    if (arr[j] != arr[k]) {
                        long left = 1, right = 1;
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }
                        answer += left * right;
                        answer %= mod;
                        j++;
                        k--;
                    } else {
                        long count = k - j + 1;
                        answer += count * (count - 1) / 2; 
                        answer %= mod;
                        break; 
                    }
                }
            }
        }

        return (int) answer;
    }
}

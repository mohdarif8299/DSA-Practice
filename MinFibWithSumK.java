class Solution {
    public int findMinFibonacciNumbers(int k) {
         List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);
        
        while (fibonacciNumbers.get(fibonacciNumbers.size() - 1) < k) {
            int nextFib = fibonacciNumbers.get(fibonacciNumbers.size() - 1) + fibonacciNumbers.get(fibonacciNumbers.size() - 2);
            fibonacciNumbers.add(nextFib);
        }
        
        int count = 0;
        int index = fibonacciNumbers.size() - 1;
        
        while (k > 0) {
            if (fibonacciNumbers.get(index) <= k) {
                k -= fibonacciNumbers.get(index);
                count++;
            }
            index--;
        }
        
        return count;
    }
}

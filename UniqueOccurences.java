class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occurrenceSet = new HashSet<>();
        for (int frequency : frequencyMap.values()) {
            if (!occurrenceSet.add(frequency)) {
                return false;
            }
        }
        return true;
    }
}

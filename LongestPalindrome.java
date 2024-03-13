class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int longestLength = 0;
        boolean hasOddFrequency = false;
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                longestLength += count;
            } else {
                longestLength += count - 1;
                hasOddFrequency = true;
            }
        }
        
        if (hasOddFrequency) {
            longestLength++;
        }
        return longestLength;
    }
}

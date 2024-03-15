class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
         Map<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                int length = i - map.get(c) - 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        
        return maxLength;
    }
}

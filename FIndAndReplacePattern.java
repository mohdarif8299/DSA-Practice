class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matchesPattern(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    private boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (!wordToPattern.containsKey(w)) {
                wordToPattern.put(w, p);
            }
            if (!patternToWord.containsKey(p)) {
                patternToWord.put(p, w);
            }
            
            if (wordToPattern.get(w) != p || patternToWord.get(p) != w) {
                return false;
            }
        }
        
        return true;
    }
}

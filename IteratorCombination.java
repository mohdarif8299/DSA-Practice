class CombinationIterator {

    private List<String> combinations;
    private Iterator<String> iterator;

    public CombinationIterator(String characters, int combinationLength) {
          combinations = new ArrayList<>();
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
        iterator = combinations.iterator();
    }
    
     private void generateCombinations(String characters, int len, int start, StringBuilder sb) {
        if (len == 0) {
            combinations.add(sb.toString());
            return;
        }
        for (int i = start; i <= characters.length() - len; i++) {
            sb.append(characters.charAt(i));
            generateCombinations(characters, len - 1, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

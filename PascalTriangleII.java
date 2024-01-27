class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1); // Add 1 at the beginning of the list
            
            for (int j = 1; j < row.size() - 1; j++) {
                // Update values in the middle of the list
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        
        return row;
    }
}

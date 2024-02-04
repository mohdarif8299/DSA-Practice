class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char currentChar = (char) (columnNumber % 26 + 'A');
            result.insert(0, currentChar);
            columnNumber /= 26;
        }

        return result.toString();
    }
}

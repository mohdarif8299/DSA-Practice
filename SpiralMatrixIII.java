class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int r = rStart, c = cStart;
        int directionIndex = 0;
        int stepSize = 1;
        int stepCount = 0;
        int index = 0;
        
        while (index < rows * cols) {
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                result[index][0] = r;
                result[index][1] = c;
                index++;
            }
            
            r += directions[directionIndex][0];
            c += directions[directionIndex][1];
            
            stepCount++;
            if (stepCount == stepSize) {
                stepCount = 0;
                directionIndex = (directionIndex + 1) % 4;
                
                if (directionIndex % 2 == 0) // Increase stepSize for every two turns
                    stepSize++;
            }
        }
        
        return result;
    }
}

class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M == null ||M.length == 0 || M[0] == null || M[0].length == 0) {
            return null;
        }
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                int sum = 0;
                int count = 0;
                for(int i : new int[]{-1, 0 ,1}) {
                    for (int j : new int[]{-1, 0 , 1}) {
                        if(isValid(rows, cols, row+i, col+j)) {
                            sum += M[row+i][col+j];
                            count++;
                        }
                    }
                }
                result[row][col]=sum/count;
            }
        }
        return result;
    }
    
    private boolean isValid(int rows, int cols, int i, int j) {
        if(i >= 0 && i < rows && j >=0 && j < cols) {
            return true;
        }
        return false;
    }
}
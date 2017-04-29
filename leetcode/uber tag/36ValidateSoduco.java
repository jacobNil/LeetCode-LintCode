// April 29, uber tage 

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //corner case
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        //validate rows
        for(int row = 0; row < board.length; row++) {
            boolean[] used = new boolean[10];
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                int digit = board[row][col] - '0';
                if(used[digit]) {
                    return false;
                }
                used[digit] = true;
            }
        }
        
        //validate cols
        for(int col = 0; col < board[0].length; col++) {
            boolean[] visited = new boolean[10];
            for(int row = 0; row < board.length; row++) {
                if(board[row][col] == '.') {
                    continue;
                }
                int digit = board[row][col] - '0';
                if(visited[digit]) {
                    return false;
                }
                visited[digit] = true;
            }
        }
        //validate 3*3 matrices
        int matrixSize = 3;
        for(int i = 0; i*matrixSize < board.length; i++) {
            for(int j = 0; j*matrixSize < board[0].length; j++) {
                if (!isMatrixValid(i*matrixSize, j*matrixSize, matrixSize, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean isMatrixValid(int row, int col, int matrixSize, char[][] board) {
        boolean[] visited = new boolean[10];
        
        for(int i = row; i < (row + matrixSize); i++) {
            for(int j = col; j < (col + matrixSize); j++) {
                if(board[i][j] == '.') continue;
                
                int digit = board[i][j] - '0';
                if(visited[digit]) {
                    return false;
                }
                visited[digit] = true;
            }
        }
        return true;
    }
}

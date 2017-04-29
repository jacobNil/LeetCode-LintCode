
// April 28, uber tag


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        
        int startRow = 0;
        int endRow = matrix.length -1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        
        while(startRow <= endRow && startCol <= endCol) {
            
            row = startRow;
            col = startCol;
            
            //end case
            if(startRow == endRow) {
                for(col = startCol; col <= endCol; col++) {
                    System.out.println(row + ": " + col);
                    result.add(matrix[row][col]);
                }
                break;
            }
            if(startRow != endRow && startCol == endCol) {
                for(row = startRow; row <= endRow; row++) {
                    result.add(matrix[row][col]);
                }
                break;
            }
            
            // left
            for(col = startCol; col< endCol; col++) {
                result.add(matrix[row][col]);
            }
            //down
            for(row = startRow; row < endRow; row++) {
                result.add(matrix[row][col]);
            }
            //left
            for(col = endCol; col > startCol; col--) {
                result.add(matrix[row][col]);
            }
            //up
            for(row = endRow; row > startRow; row--) {
                result.add(matrix[row][col]);
            }
            
            startRow++;
            endRow--;
            startCol++;
            endCol--;
            
        }
        return result;
    }
}

// A slightly different solution
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        
        int startRow = 0;
        int endRow = matrix.length -1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        
        while(startRow <= endRow && startCol <= endCol) {
            
            row = startRow;
            col = startCol;
            
            // left
            for(col = startCol; col<= endCol; col++) {
                result.add(matrix[startRow][col]);
            }
            startRow++;
            //down
            for(row = startRow; row <= endRow; row++) {
                result.add(matrix[row][endCol]);
            }
            endCol--;
            //left
            for(col = endCol; col >= startCol; col--) {
                result.add(matrix[endRow][col]);
            }
            endRow--;
            //up
            for(row = endRow; row >= startRow; row--) {
                result.add(matrix[row][startCol]);
            }
            startCol++;
            
        }
        return result;
    }
}

















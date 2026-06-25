class Solution {
    public boolean exist(char[][] board, String word) {
       int rows = board.length;
        int cols = board[0].length;
        
        // Step 1: Scan the grid for the first letter of the word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // Step 2: Start backtracking search from this cell
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // Base Case: If we matched all characters, we found the word
        if (index == word.length()) {
            return true;
        }
        
        // Base Case: Check boundaries and if the current cell matches the character
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Mark the cell as visited by saving it and replacing it with a placeholder
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        // Explore all 4 possible directions: Down, Up, Right, Left
        boolean found = backtrack(board, word, r + 1, c, index + 1) ||
                        backtrack(board, word, r - 1, c, index + 1) ||
                        backtrack(board, word, r, c + 1, index + 1) ||
                        backtrack(board, word, r, c - 1, index + 1);
        
        // Backtrack: Restore the original character for other potential paths
        board[r][c] = temp;
        
        return found;
     
    }
}

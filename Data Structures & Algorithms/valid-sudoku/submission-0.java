class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentCell = board[r][c];
                
                // Skip empty spots
                if (currentCell == '.') {
                    continue;
                }

                // Convert char digit to integer value
                int num = currentCell - '0';
                
                // Calculate the matching 3x3 box index (0 to 8)
                int boxIdx = (r / 3) * 3 + (c / 3);

                // If this number has already been seen in this row, col, or box, it's invalid!
                if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                    return false;
                }

                // Mark this number as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIdx][num] = true;
            }
        }

        return true;
    }
}

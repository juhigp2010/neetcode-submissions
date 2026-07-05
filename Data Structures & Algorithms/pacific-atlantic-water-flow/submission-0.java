class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
   List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // 1. Start DFS from the top and bottom rows (Horizontal borders)
        for (int c = 0; c < cols; c++) {
            // Top row borders the Pacific
            dfs(heights, 0, c, pacificReachable, heights[0][c]);
            // Bottom row borders the Atlantic
            dfs(heights, rows - 1, c, atlanticReachable, heights[rows - 1][c]);
        }

        // 2. Start DFS from the left and right columns (Vertical borders)
        for (int r = 0; r < rows; r++) {
            // Left column borders the Pacific
            dfs(heights, r, 0, pacificReachable, heights[r][0]);
            // Right column borders the Atlantic
            dfs(heights, r, cols - 1, atlanticReachable, heights[r][cols - 1]);
        }

        // 3. Find cells that can reach both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] reachable, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Base cases for boundary check, duplication check, and height constraint
        // (Water flows to equal or lower height, so reverse-flow must go to equal or higher height)
        if (r < 0 || r >= rows || c < 0 || c >= cols || reachable[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // Mark the current cell as reachable
        reachable[r][c] = true;

        // Traverse in all 4 directions
        dfs(heights, r + 1, c, reachable, heights[r][c]); // Down
        dfs(heights, r - 1, c, reachable, heights[r][c]); // Up
        dfs(heights, r, c + 1, reachable, heights[r][c]); // Right
        dfs(heights, r, c - 1, reachable, heights[r][c]); // Left
    }
}
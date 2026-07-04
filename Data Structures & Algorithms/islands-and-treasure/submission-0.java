class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        // Edge case: if the grid is empty, there's nothing to do
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Find all treasure chests (0) and add them to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Direction vectors for moving Up, Down, Left, and Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                // Check boundaries and if the cell is an unvisited land cell (INF)
                if (r >= 0 && r < m && c >= 0 && c < n && rooms[r][c] == Integer.MAX_VALUE) {
                    // Update the distance to the current cell's distance + 1
                    rooms[r][c] = rooms[row][col] + 1;
                    // Push the newly updated land cell to the queue
                    queue.offer(new int[]{r, c});
                }
            }
        }
    
    }
}

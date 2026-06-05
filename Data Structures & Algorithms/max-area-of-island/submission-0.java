class Solution {
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;    
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = floodFill(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
            
    }

    int[] moves = {-1, 0, 1, 0, -1};
    
    private int floodFill(int[][] grid, int i, int j) {
        int count = 1;
        grid[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                count += floodFill(grid, x, y);
            }
        }

        return count;
    }
}

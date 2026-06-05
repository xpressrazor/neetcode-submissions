class Solution {
    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;    
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    floodFill(grid, i, j);
                }
            }
        }

        return count;
    }

    int[] moves = {-1, 0, 1, 0, -1};
    
    private void floodFill(char[][] grid, int i, int j) {
        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                floodFill(grid, x, y);
            }
        }
    }
}

class Solution {
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getArea(grid, i, j));
                }
            }
        }

        return max;
    }

    private int[] moves = {-1, 0, 1, 0, -1};

    private int getArea(int[][] grid, int i, int j) {
        int count = 1;
        grid[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k + 1];

            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                count += getArea(grid, x, y);
            }
        }

        return count;
    }
}

class Solution {
    static final int INF = Integer.MAX_VALUE / 4;
    int n;

    public int swimInWater(int[][] grid) {
        n = grid.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }

        int lo = min, hi = max;
        boolean[][] visited = new boolean[n][n];

        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (dfs(grid, 0, 0, visited, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

            visited = new boolean[n][n];
        }

        return hi;
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited, int t) {
        if (grid[i][j] > t) {
            return false;
        }

        if (i == n-1 && j == n-1) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                if (dfs(grid, x, y, visited, t)) {
                    return true;
                }
            }
        }

        return false;
    }
}

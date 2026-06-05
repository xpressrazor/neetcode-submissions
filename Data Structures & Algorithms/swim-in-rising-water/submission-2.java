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

            if (dfs(grid, visited, 0, 0, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

            visited = new boolean[n][n];
        }

        return hi;
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid.length || visit[r][c] || grid[r][c] > t) {
            return false;
        }
        if (r == grid.length - 1 && c == grid.length - 1) {
            return true;
        }
        visit[r][c] = true;
        return dfs(grid, visit, r + 1, c, t) ||
               dfs(grid, visit, r - 1, c, t) ||
               dfs(grid, visit, r, c + 1, t) ||
               dfs(grid, visit, r, c - 1, t);
    }
}

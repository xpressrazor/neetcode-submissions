class Solution {
    int n;
    static final int INF = Integer.MAX_VALUE / 4;

    public int swimInWater(int[][] grid) {
        n = grid.length;
        boolean[][] visited = new boolean[n][n];

        return dfs(grid, 0, 0, 0, visited);
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private int dfs(int[][] grid, int i, int j, int t, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) {
            return INF;
        }

        t = Math.max(t, grid[i][j]);
        if (i == n-1 && j == n-1) {
            return t;
        }

        visited[i][j] = true;
        int res = INF;

        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < n && y >= 0 && y < n) {
                res = Math.min(res, dfs(grid, x, y, t, visited));
            }
        }

        visited[i][j] = false;
        return res;
    }
}

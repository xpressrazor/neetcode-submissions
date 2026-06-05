class Solution {
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, visited));
            }
        } 

        return max;   
    }

    int[] moves = {-1, 0, 1, 0, -1};

    private int dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int res = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + moves[k];
            int y = j + moves[k+1];

            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, x, y, visited));
            }
        }

        visited[i][j] = false;
        return res + 1;
    }
}

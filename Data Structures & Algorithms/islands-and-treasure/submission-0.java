class Solution {
    static final int INF = 2147483647;
    int[] moves = new int[] {-1, 0, 1, 0, -1};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {0, i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                
                for (int k = 0; k < 4; k++) {
                    int x = cur[1] + moves[k];
                    int y = cur[2] + moves[k+1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == INF) {
                        grid[x][y] = cur[0] + 1;
                        queue.add(new int[] {cur[0] + 1, x, y});
                    }
                }
            }
        }
    }
}

class Solution {
    int[] moves = {-1, 0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {grid[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], i = cur[1], j = cur[2];

            if (i == n-1 && j == n-1) {
                return t;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + moves[k];
                int y = j + moves[k+1];

                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.add(new int[] {Math.max(t, grid[x][y]), x, y});
                }
            }
        }

        return n * n;    
    }
}

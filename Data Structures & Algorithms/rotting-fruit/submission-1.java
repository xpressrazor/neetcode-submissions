class Solution {
    int[] moves = {-1, 0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int minutes = -1;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int freshFruits = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }

        if (freshFruits == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + moves[k];
                    int y = cur[1] + moves[k+1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshFruits--;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }



        return freshFruits == 0 ? minutes : -1;
    }
}

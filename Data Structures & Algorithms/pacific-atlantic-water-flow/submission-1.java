class Solution {
    int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pvisited = new boolean[m][n];
        boolean[][] avisited = new boolean[m][n];

        Queue<int[]> pqueue = new LinkedList<>();
        Queue<int[]> aqueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pqueue.add(new int[] {i, j});
                }

                if (j == n-1 || i == m-1) {
                    aqueue.add(new int[] {i, j});
                }
            }
        }

        bfs(heights, pqueue, pvisited);
        bfs(heights, aqueue, avisited);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pvisited[i][j] && avisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private int[] moves = {-1, 0, 1, 0, -1};

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + moves[k];
                int y = cur[1] + moves[k + 1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] 
                    && heights[x][y] >= heights[cur[0]][cur[1]]) {
                    queue.add(new int[] {x, y});
                }
            }
        }
    }
}

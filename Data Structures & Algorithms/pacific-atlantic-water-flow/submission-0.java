class Solution {
    int[] moves = {-1, 0, 1, 0, -1};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        Queue<int[]> pqueue = new LinkedList<>();
        Queue<int[]> aqueue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pqueue.add(new int[]{i, 0});
            aqueue.add(new int[]{i, n-1});
        }

        for (int i = 0; i < n; i++) {
            pqueue.add(new int[]{0, i});
            aqueue.add(new int[]{m-1, i});
        }

        boolean[][] pvisited = new boolean[m][n];
        boolean[][] avisited = new boolean[m][n];

        bfs(pqueue, pvisited, heights);
        bfs(aqueue, avisited, heights);

        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (avisited[i][j] && pvisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + moves[k];
                int y = cur[1] + moves[k+1];

                if (x >= 0 && x < m && y >= 0 && y >= 0 && y < n && !visited[x][y] 
                    && heights[x][y] >= heights[cur[0]][cur[1]]) {
                    queue.add(new int[] {x, y});
                }
            }
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                count++;
            }
        }

        return count;
    }

    private void bfs(List<List<Integer>> graph, int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;

            for (int neighbor : graph.get(cur)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }
}

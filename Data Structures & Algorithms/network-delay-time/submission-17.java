class Solution {
    
    private static final int INF = Integer.MAX_VALUE / 4;

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new int[] {time[1], time[2]});
        }

        int[] dist = new int[n+1];
        dijkstra(graph, dist, k);

        int minTime = 0;
        
        for (int i = 1; i <= n; i++) {
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime == INF ? -1 : minTime;
    }

    private void dijkstra(List<List<int[]>> graph, int[] dist, int src) {
        Arrays.fill(dist, INF);
        dist[src] = 0;
        boolean[] visited = new boolean[graph.size()];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[] {src, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            visited[u] = true;

            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                int w = nei[1];

                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[] {v, dist[v]});
                }
            }
        }
    }
}

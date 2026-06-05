class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

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

        int minTimeRequired = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }

            minTimeRequired = Math.max(minTimeRequired, dist[i]);
        }

        return minTimeRequired;
    }

    private void dijkstra(List<List<int[]>> graph, int[] dist, int src) {
        Arrays.fill(dist, INF);
        dist[src] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0});

        while (!pq.isEmpty()) {
            int size = pq.size();

            while (size-- > 0) {
                int[] cur = pq.poll();
                int u = cur[0];

                if (dist[u] < cur[1]) {
                    continue;
                }

                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];

                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        pq.add(new int[] {v, dist[v]});
                    }
                }

            }
        }
    }
}

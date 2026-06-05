class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        int[][] dist = new int[n][k+10]; // extra space
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        dist[src][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0, -1});  // src, price, steps (-1 for src)

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w1 = cur[1], stops = cur[2];

            if (u == dst) {
                return w1;
            }

            if (stops == k || dist[u][stops + 1] < w1) continue;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w2 = neighbor[1];
                int w = w1 + w2;
                int nextStops = stops + 1;

                if (dist[v][nextStops + 1] > w) {
                    dist[v][nextStops + 1] = w;
                    pq.add(new int[] {v, w, nextStops});
                }
            }
        }

        return -1;
    }
}

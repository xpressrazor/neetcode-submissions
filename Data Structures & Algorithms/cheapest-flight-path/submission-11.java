class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman-ford
        // O(n + k * m)
        
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmpdist = Arrays.copyOf(dist, n);

            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];

                if (dist[u] != INF && tmpdist[v] > dist[u] + w) {
                    tmpdist[v] = dist[u] + w;
                }
            }

            dist = tmpdist;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}

class Solution {
    private static final int INF = Integer.MAX_VALUE / 4;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k-1] = 0;

        for (int i = 0; i < n-1; i++) {
            for (int[] time : times) {
                // 0-based index
                int u = time[0] - 1, v = time[1] - 1, w = time[2];

                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        int res = Arrays.stream(dist).max().getAsInt();
        return res == INF ? -1 : res;
    }
}

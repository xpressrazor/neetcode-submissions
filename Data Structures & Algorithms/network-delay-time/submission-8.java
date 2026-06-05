class Solution {
    private static final int INF = Integer.MAX_VALUE / 4;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, w = time[2];

            dist[u][v] = w;
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
                }
            }
        }

        int res = Arrays.stream(dist[k-1]).max().getAsInt();
        return res == INF ? -1 : res;
    }
}

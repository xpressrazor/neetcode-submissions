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
        Arrays.fill(dist, INF);

        dfs(graph, dist, k, 0);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }

        return res == INF ? -1 : res;
    }

    private void dfs(List<List<int[]>> graph, int[] dist, int src, int time) {
        if (time >= dist[src]) {
            return;
        }

        dist[src] = time;

        for (int[] neighbor : graph.get(src)) {
            dfs(graph, dist, neighbor[0], time + neighbor[1]);
        }
    }
}

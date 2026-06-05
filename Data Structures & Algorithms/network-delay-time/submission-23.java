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
        Arrays.fill(dist, INF);

        dist[k] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {k, dist[k]});

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int u = cur[0], w1 = cur[1];

                if (dist[u] < w1) {
                    continue;
                }

                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w2 = neighbor[1];
                    int w = w1 + w2;

                    if (dist[v] > w) {
                        dist[v] = w;
                        queue.add(new int[]{v, dist[v]});
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }

        return res == INF ? -1 : res;
    }
}

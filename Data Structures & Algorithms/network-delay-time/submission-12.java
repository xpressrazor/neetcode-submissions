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
        dist[k] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {k, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int u = cur[0];

                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];

                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        queue.add(new int[] {v, dist[v]});
                    }
                }

            }
        }

        
        int minTimeRequired = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }

            minTimeRequired = Math.max(minTimeRequired, dist[i]);
        }

        return minTimeRequired;
    }
}

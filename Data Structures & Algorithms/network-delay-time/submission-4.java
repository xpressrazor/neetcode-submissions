class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graphMap = new HashMap<>();
        for (int[] time : times) {
            graphMap.computeIfAbsent(time[0], x -> new ArrayList<>())
                .add(new int[] {time[1], time[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        //dist[k] = 0;
        
        dfs(k, 0, graphMap, dist);
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }

        return res == INF ? -1 : res;
    }

    private void dfs(int src, int time, Map<Integer, List<int[]>> graphMap, 
        int[] dist) {
        
        if (time >= dist[src]) {
            return;
        }

        dist[src] = time;

        if (!graphMap.containsKey(src)) {
            return;
        }

        for (int[] edge : graphMap.get(src)) {
            dfs(edge[0], time + edge[1], graphMap, dist);
        }
    }
}

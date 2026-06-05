class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        dist[0] = 0;
        
        boolean[] visited = new boolean[n];

        int edges = 0, res = 0, node = 0;

        while (edges < n-1) {
            visited[node] = true;
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                int distance = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], distance);

                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            res += dist[nextNode];
            node = nextNode;
            edges++;
        }

        return res;
    }
}

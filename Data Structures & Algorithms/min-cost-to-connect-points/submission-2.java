class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                graph.get(i).add(new int[] {j, distance});
                graph.get(j).add(new int[] {i, distance});
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[] {0, 0});

        while (visited.size() < n) {
            int[] cur = pq.poll();
            int u = cur[0];
            int cost = cur[1];
            
            if (visited.contains(u)) {
                continue;
            }

            visited.add(u);
            res += cost;
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                if (!visited.contains(v)) {
                    pq.add(new int[] {v, w});
                }
            }
        }

        return res;
    }
}

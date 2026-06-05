class Solution {
    public int minCostConnectPoints(int[][] points) {
        // prim's algorithm
        // pick lowest distance edge that connects a node to a free node
        int n = points.length;
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                graph.get(i).add(new int[]{j, distance});
                graph.get(j).add(new int[] {i, distance});
            }
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[] {0, 0});
        int res = 0;

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

                if (visited.contains(v)) {
                    continue;
                }

                pq.add(new int[] {v, w});
            }
        }

        return res;
    }
}

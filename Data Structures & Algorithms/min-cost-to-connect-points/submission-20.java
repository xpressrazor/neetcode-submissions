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

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[] {0, 0});

        int res = 0;

        while (visited.size() < n) {
            int[] cur = queue.poll();
            int u = cur[0], w1 = cur[1];

            if (visited.contains(u)) {
                continue;
            }

            visited.add(u);

            res += w1;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int w2 = neighbor[1];

                if (!visited.contains(v)) {
                    queue.add(new int[] {v, w2});
                }
            }
        }

        return res;
    }
}

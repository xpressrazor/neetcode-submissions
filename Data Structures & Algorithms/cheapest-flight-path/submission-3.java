class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        queue.add(new int[] {src, 0});
        
        int count = 0;

        while (!queue.isEmpty() && count <= k) {
            int size = queue.size();
            
            while (size-- > 0) {
                int[] cur = queue.poll();
                int u = cur[0];
                
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];

                    if (w + cur[1] < dist[v]) {
                        dist[v] = w + cur[1];
                        queue.add(new int[] {v, dist[v]});
                    }
                }
            }

            count++;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}

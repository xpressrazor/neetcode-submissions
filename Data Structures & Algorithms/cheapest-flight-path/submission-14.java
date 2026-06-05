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

        // dijkstra's algorithm
        int[][] prices = new int[n][k+10];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(prices[i], INF);
        }

        prices[src][0] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, 0, 0});

        // k + 1 steps for k stops
        while (!pq.isEmpty()) {
            int size = pq.size();

            while (size-- > 0) {
                int[] cur = pq.poll();

                int u = cur[0], w1 = cur[1], steps = cur[2];

                if (u == dst) {
                    return w1;
                }

                // for same 
                /*
                if (steps == k + 1 || prices[u][steps] < w1) {
                    continue;
                }
                */
                if (steps == k + 1) {
                    continue;
                }

                int nextStep = steps + 1;

                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0], w2 = neighbor[1];
                    int w = w1 + w2;
                    
                    if (prices[v][nextStep] > w) {
                        prices[v][nextStep] = w;
                        pq.add(new int[] {v, w, nextStep});
                    }
                }
            }
        }

        return -1;

    }
}

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

        int[] prices = new int[n];
        Arrays.fill(prices, INF);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {src, 0});
        
        while (!queue.isEmpty() && k-- >= 0) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int u = cur[0], w1 = cur[1];

                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0], w2 = neighbor[1];
                    int w = w1 + w2;

                    if (w < prices[v]) {
                        prices[v] = w;
                        queue.add(new int[] {v, w});
                    }
                }
            }
        }

        return prices[dst] == INF ? -1 : prices[dst];

    }
}

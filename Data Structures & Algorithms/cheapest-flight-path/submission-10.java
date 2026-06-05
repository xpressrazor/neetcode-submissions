class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, INF);

        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];

                if (prices[u] != INF && prices[u] + w < tmpPrices[v]) {
                    tmpPrices[v] = prices[u] + w;
                }
            }

            prices = tmpPrices;
        }

        return prices[dst] == INF ? -1 : prices[dst]; 
    }
}

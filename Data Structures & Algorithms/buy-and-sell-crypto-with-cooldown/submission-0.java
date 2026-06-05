class Solution {
    private Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int index, boolean buying) {
        if (index >= prices.length) {
            return 0;
        }

        String key = index + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(prices, index + 1, buying);

        if (buying) {
            int buy = dfs(prices, index + 1, !buying) - prices[index];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(prices, index + 2, !buying) + prices[index];
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}

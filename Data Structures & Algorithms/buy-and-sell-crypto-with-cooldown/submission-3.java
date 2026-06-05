class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp_buy1 = 0, dp_buy2 = 0, dp_sell1 = 0;

        for (int i = n-1; i >= 0; i--) {
            int p = prices[i];
            int dp_buy = Math.max(dp_buy1, dp_sell1 - p);
            int dp_sell = Math.max(dp_sell1, dp_buy2 + p);

            dp_buy2 = dp_buy1;
            dp_buy1 = dp_buy;
            dp_sell1 = dp_sell;
        }

        return dp_buy1;
    }
}

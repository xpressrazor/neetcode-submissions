class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, i = 0, j = 1;

        int max = 0;

        while (j < n) {
            if (prices[i] < prices[j]) {
                max = Math.max(max, prices[j] - prices[i]);
            } else {
                i = j;
            }
            j++;
        }

        return max;
    }
}

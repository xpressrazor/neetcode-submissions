class Solution {
    public int maxProfit(int[] prices) {
        var n = prices.length;
        var max = 0;
        var i = 0;
        var j = 1;

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

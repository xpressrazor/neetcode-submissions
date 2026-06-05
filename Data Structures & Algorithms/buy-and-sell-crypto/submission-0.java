class Solution {
    public int maxProfit(int[] prices) {
        var min = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (var p : prices) {
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }

        return maxProfit;
    }
}

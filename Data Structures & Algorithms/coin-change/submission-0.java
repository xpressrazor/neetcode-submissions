class Solution {
    static final int INF = Integer.MAX_VALUE / 4;
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-c] + 1);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}

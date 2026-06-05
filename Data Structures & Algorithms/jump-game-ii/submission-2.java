class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[n-1] = 0;

        for (int i = n-2; i >= 0; i--) {
            int end = Math.min(n-1, i + nums[i]);
            for (int j = i + 1; j <= end; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }

        return dp[0];    
    }
}

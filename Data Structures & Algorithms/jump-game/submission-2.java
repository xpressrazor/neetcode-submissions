class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for (int i = n-2; i >= 0; i--) {
            int end = Math.min(n-1, i + nums[i]);

            for (int j = i + 1; j <= end; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

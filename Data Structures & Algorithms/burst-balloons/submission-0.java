class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n+2];
        
        nums2[0] = 1;
        nums2[n+1] = 1;

        for (int i = 0; i < n; i++) {
            nums2[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        n = n + 2;

        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int res = 0;

                for (int k = i + 1; k < j; k++) {
                    res = Math.max(res, dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j]);
                }

                dp[i][j] = res;
            }
        }

        return dp[0][n-1];
    }
}

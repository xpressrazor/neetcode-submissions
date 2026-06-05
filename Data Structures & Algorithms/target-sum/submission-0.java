class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += Math.abs(target);
        
        if (sum % 2 == 1) {
            return 0;
        }

        int newTotal = sum / 2;
        return subset(nums, newTotal);
    }

    private int subset(int[] nums, int total) {
        int[] dp = new int[total + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = total; j >= num; j--) {
                dp[j] += dp[j-num];
            }
        }

        return dp[total];
    }
}

class Solution {
    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        
        int n = s.length();
        
        /*
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2;  i <= n; i++) {
            int cur = s.charAt(i-1) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i-1];
            }

            int prev = (s.charAt(i-2) - '0') * 10 + cur;
            if (prev >= 10 && prev <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
        */
        int dp1 = 1;
        int dp2 = 1;

        for (int i = 2; i <= n; i++) {
            int cur = s.charAt(i - 1) - '0';
            int dp = 0;

            if (cur >= 1 && cur <= 9) {
                dp += dp2;
            }

            int prev = (s.charAt(i-2) - '0') * 10 + cur;
            if (prev >= 10 && prev <= 26) {
                dp += dp1;
            }

            dp1 = dp2;
            dp2 = dp;
        }

        return dp2;
    }
}

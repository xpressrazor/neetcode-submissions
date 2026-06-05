class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        dp[n][0] = true;

        for (int i = n-1; i >= 0; i--) {
            for (int open = 0; open < n; open++) {
                boolean res = false;

                if (s.charAt(i) == '(') {
                    res |= dp[i+1][open+1];
                } else if (s.charAt(i) == ')') {
                    if (open > 0) {
                        res |= dp[i+1][open-1];
                    }
                } else {
                    res |= dp[i+1][open+1];
                    
                    if (open > 0) {
                        res |= dp[i+1][open-1];
                    }

                    res |= dp[i+1][open];
                }

                dp[i][open] = res;
            }
        }

        return dp[0][0];
    }
}

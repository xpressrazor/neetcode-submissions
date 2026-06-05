class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = n-1; i >= 0; i--) {
            
            boolean[] newDP = new boolean[n+1];

            for (int open = 0; open < n; open++) {
                boolean res = false;

                if (s.charAt(i) == '(') {
                    res |= dp[open+1];
                } else if (s.charAt(i) == ')') {
                    if (open > 0) {
                        res |= dp[open-1];
                    }
                } else {
                    res |= dp[open+1];
                    
                    if (open > 0) {
                        res |= dp[open-1];
                    }

                    res |= dp[open];
                }

                newDP[open] = res;
            }

            dp = newDP;
        }

        return dp[0];
    }
}

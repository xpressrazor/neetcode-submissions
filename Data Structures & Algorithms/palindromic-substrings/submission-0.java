class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int count = 0;

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(i + 1 >= j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

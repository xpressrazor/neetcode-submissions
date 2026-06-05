class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> dict = new HashSet<>(wordDict);

        for (int i = 0; i <= n; i++) {
            if (dict.contains(s.substring(0, i))) {
                dp[i] = true;
            }

            if (dp[i]) {
                for (int j = i; j <= n; j++) {
                    if (dict.contains(s.substring(i, j))) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[n];
    }
}

class Solution {
    private int n;
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        palindromedp(s, dp);
        dfs(s, dp, 0, new ArrayList<>());

        return result;
    }

    private void palindromedp(String s, boolean[][] dp) {
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0; i < n-gap; i++) {
                int j = i + gap;

                if (s.charAt(i) == s.charAt(j) && (j <= i + 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
    }

    private void dfs(String s, boolean[][] dp, int i, List<String> tmp) {
        if (i == n) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    tmp.add(s.substring(i, j + 1));
                    dfs(s, dp, j + 1, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}

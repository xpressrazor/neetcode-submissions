class Solution {
    int m, n;

    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        
        Integer[][] memo = new Integer[m][n];
        return dfs(s, t, 0, 0, memo);
    }

    private int dfs(String s, String t, int i, int j, Integer[][] memo) {
        if (j == n) {
            return 1;
        } else if (i == m || m - i < n - j) {
            return 0;
        } else if (memo[i][j] != null) {
            return memo[i][j];
        } else {
            if (s.charAt(i) == t.charAt(j)) {
                return memo[i][j] = dfs(s, t, i + 1, j + 1, memo) + dfs(s, t, i + 1, j, memo);
            } else {
                return memo[i][j] = dfs(s, t, i + 1, j, memo);
            }
        }
    }
}

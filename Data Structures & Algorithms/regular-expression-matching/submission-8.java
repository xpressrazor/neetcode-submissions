class Solution {
    private int m, n;
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        memo = new Boolean[m+1][n+1];

        return isMatch(s, p, 0, 0);    
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (j == n) {
            return i == m;
        } else if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < n && p.charAt(j+1) == '*') {
            return memo[i][j] = isMatch(s, p, i, j + 2) || (match && isMatch(s, p, i + 1, j));
        } else {
            return memo[i][j] = match && isMatch(s, p, i + 1, j + 1);
        }
    }
}

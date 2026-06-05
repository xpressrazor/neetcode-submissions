class Solution {
    int m, n;

    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();

        return dfs(s, p, 0, 0);    
    }

    private boolean dfs(String  s, String p, int i, int j) {
        if (j  == n) {
            return i == m;
        }

        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < n && p.charAt(j+1) == '*') {
            return dfs(s, p, i, j + 2) || (match && dfs(s, p, i + 1, j));
        }

        if (match) {
            return dfs(s, p, i + 1, j + 1);
        }

        return false;
    }
}

class Solution {
    
    List<String> result = new ArrayList<>();
    int n;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;

        dfs(0, 0, "");

        return result;
    }

    void dfs(int l, int r, String tmp) {
        if (l > n || r > n || l < r) {
            return;
        } else if (l == n && r == n) {
            result.add(tmp);
        } else {
            dfs(l + 1, r, tmp + "(");
            dfs(l, r + 1, tmp + ")");
        }
    }
}

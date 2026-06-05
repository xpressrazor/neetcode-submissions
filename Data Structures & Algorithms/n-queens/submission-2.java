class Solution {
    boolean[] cols, diag1, diag2;
    int n;
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        int[] tmp = new int[n];
        
        solve(0, tmp);
        return result;
    }

    private void solve(int y, int[] tmp) {
        if (y == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (tmp[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }

        for (int x = 0; x < n; x++) {
            if (cols[x] || diag1[x + y] || diag2[n + x - y]) {
                continue;
            }

            cols[x] = diag1[x + y] = diag2[n + x - y] = true;
            tmp[x] = y;
            solve(y + 1, tmp);
            cols[x] = diag1[x + y] = diag2[n + x - y] = false;
        }
    }
}

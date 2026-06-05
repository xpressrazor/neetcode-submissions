class Solution {
    private List<List<String>> result = new ArrayList<>();
    int n;
    boolean[] cols, diag1, diag2;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        int[] tmp = new int[n];

        solve(tmp, 0);    

        return result;
    }

    private void solve(int[] tmp, int y) {
        if (y == n) {
            
            List<String> l = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (j == tmp[i]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                l.add(sb.toString());
            }

            result.add(l);

            return;
        }

        for (int x = 0; x < n; x++) {
            if (cols[x] || diag1[x + y] || diag2[n + x - y]) {
                continue;
            }

            cols[x] = diag1[x + y] = diag2[n + x - y] = true;
            tmp[x] = y;
            solve(tmp, y + 1);
            cols[x] = diag1[x + y] = diag2[n + x - y] = false;
        }
    }
}

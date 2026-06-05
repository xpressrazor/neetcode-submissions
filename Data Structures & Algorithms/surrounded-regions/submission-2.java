class Solution {

    static class UnionFind {
        int[] p, size;

        public UnionFind(int n) {
            p = new int[n+1];
            size = new int[n+1];

            for (int i = 0; i <= n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (p[i] == i) {
                return i;
            }
            return p[i] = find(p[i]);
        }

        public boolean union(int i, int j) {
            int x = find(i);
            int y = find(j);

            if (x == y) {
                return false;
            }

            if (size[x] >= size[y]) {
                p[y] = x;
                size[x] += size[y];
            } else {
                p[x] = y;
                size[y] += size[x];
            }

            return true;
        }

        public boolean isconnected(int i, int j) {
            return find(i) == find(j);
        }
    }

    int[] moves = {-1, 0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }

                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    uf.union(m * n, i * n + j);
                } else {
                    for (int k = 0; k < 4; k++) {
                        int x = i + moves[k];
                        int y = j + moves[k+1];

                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.isconnected(i * n + j, m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

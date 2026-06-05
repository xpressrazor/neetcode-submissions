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

        public int getSize(int i) {
            return size[find(i)];
        }
    }

    int[] moves = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //grid[i][j] = 0;

                    for (int k = 0; k < 4; k++) {
                        int x = i + moves[k];
                        int y = j + moves[k+1];

                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                            //grid[x][y] = 0;        
                        }
                    }

                    maxArea = Math.max(maxArea, uf.getSize(i * n + j));
                }
            }
            
        }

        return maxArea;
    }
}

class Solution {

    static class UnionFind {
        int[] p, size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
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

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);

            if (size[x] >= size[y]) {
                size[x] += size[y];
                p[y] = x;
            } else {
                size[y] += size[x];
                p[x] = y;
            }
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }

    int[] moves = {-1, 0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions.add(new int[] {grid[i][j], i, j});
            }
        }

        Collections.sort(positions, (a, b) -> a[0] - b[0]);

        for (int[] position : positions) {
            int i = position[1], j = position[2], t = position[0];

            for (int k = 0; k < 4; k++) {
                int x = i + moves[k];
                int y = j + moves[k+1];

                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] <= t) {
                    uf.union(i * n + j, x * n + y);                    
                }
            }

            if (uf.connected(0, n * n - 1)) {
                return t;
            }
        }
        
        return n * n;
    }
}

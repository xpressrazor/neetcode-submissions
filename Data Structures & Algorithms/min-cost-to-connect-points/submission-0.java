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

            if (x == y) {
                return;
            }

            if (size[x] >= size[y]) {
                p[y] = x;
                size[x] += size[y];
            } else {
                p[x] = y;
                size[y] += size[x];
            }
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edgeList.add(new int[] {distance, i, j});
            }
        }

        Collections.sort(edgeList, (a, b) -> a[0] - b[0]);

        UnionFind uf = new UnionFind(n + 1);
        int res = 0;

        for (int[] edge : edgeList) {
            if (!uf.isConnected(edge[1], edge[2])) {
                res += edge[0];
                uf.union(edge[1], edge[2]);
            }
        }

        return res;
    }
}

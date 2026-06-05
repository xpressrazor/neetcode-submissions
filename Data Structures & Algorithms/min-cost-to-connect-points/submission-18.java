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

        public boolean union(int i, int j) {
            int x = find(i);
            int y = find(j);

            if (x == y) {
                return false;
            }

            if (size[x] >= size[y]) {
                size[x] += size[y];
                p[y] = x;
            } else {
                size[y] += size[x];
                p[x] = y;
            }

            return true;
        }
    }

    // Krukal's: sort edges, pick free minimum weight edge
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edgeList = new ArrayList<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edgeList.add(new int[] {i, j, distance});
            }
        }

        Collections.sort(edgeList, (a, b) -> a[2] - b[2]);
        int edges = 0;
        UnionFind uf = new UnionFind(n);
        int res = 0;

        for (int[] edge : edgeList) {
            if (uf.union(edge[0], edge[1])) {
                res += edge[2];
            }
        }

        return res;
    }
}

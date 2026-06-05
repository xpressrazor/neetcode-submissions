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

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);

            if (x == y) {
                return;
            }

            if (size[x] >= y) {
                size[y] += size[y];
                p[y] = x;
            } else {
                size[x] += size[y];
                p[x] = y;
            }
        }

        public int find(int i) {
            if (p[i] == i) {
                return i;
            }

            return p[i] = find(p[i]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            int x = uf.find(edge[0]);
            int y = uf.find(edge[1]);

            if (x == y) {
                return new int[] {edge[0], edge[1]};
            }

            uf.union(edge[0], edge[1]);
        }

        return null;
    }
}

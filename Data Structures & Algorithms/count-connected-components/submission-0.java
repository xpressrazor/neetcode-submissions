class Solution {
    static class UnionFind {
        int[] p, size;
        int setSize;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }

            setSize = n;
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
            setSize--;
        }

        public int getSetSize() {
            return setSize;
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getSetSize();
    }
}

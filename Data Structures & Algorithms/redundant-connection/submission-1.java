class Solution {
    int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        p = new int[n];
        Arrays.fill(p, -1);

        for (int[] edge : edges) {
            int x = find(p, edge[0]);
            int y = find(p, edge[1]);

            if (x == y) {
                return new int[] {edge[0], edge[1]};
            }

            p[x] = y;
        }

        return null;
    }

    private int find(int[] p, int i) {
        if (p[i] == -1) {
            return i;
        }

        return p[i] = find(p, p[i]);
    }
}

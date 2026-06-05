class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        Arrays.fill(p, -1);

        for (int[] edge : edges) {
            int x = find(p, edge[0]);
            int y = find(p, edge[1]);

            if (x == y) {
                return false;
            }

            p[y] = x;
        }

        return edges.length == n-1;
    }

    private int find(int[] p, int i) {
        if (p[i] == -1) {
            return i;
        }

        return p[i] = find(p, p[i]);
    }
}

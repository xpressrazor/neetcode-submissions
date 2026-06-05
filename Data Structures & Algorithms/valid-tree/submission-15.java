class Solution {
    private int[] p;

    public boolean validTree(int n, int[][] edges) {
        p = new int[n];
        Arrays.fill(p, -1);

        for (int[] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);

            if (x == y) {
                return false;
            }

            p[y] = x;
        }

        return n-1 == edges.length;
    }

    private int find(int i) {
        if (p[i] == -1) {
            return i;
        }

        return p[i] = find(p[i]);
    }
}

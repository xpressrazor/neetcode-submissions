class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inorder = new int[n];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            inorder[u]++;
            inorder[v]++;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graph.get(cur)) {
                inorder[neighbor]--;

                if (inorder[neighbor] == 1) {
                    queue.add(neighbor);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (inorder[u] == 2 && inorder[v] == 2) {
                return new int[] {u, v};
            }
        }

        return null;
    }
}

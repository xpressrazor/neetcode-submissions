class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];

        if (!visited[0] && cycle(graph, visited, stack, 0, -1)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean cycle(List<List<Integer>> graph, boolean[] visited, boolean[] stack, 
        int src, int parent) {
        
        visited[src] = true;
        stack[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (cycle(graph, visited, stack, neighbor, src)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        stack[src] = false;
        return false;
    }
}

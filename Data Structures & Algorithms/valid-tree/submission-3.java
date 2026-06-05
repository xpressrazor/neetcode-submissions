class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length > n-1) {
            return false;
        }

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
        List<Integer> orderList = new ArrayList<>();

        if (!visited[0] && cycle(graph, visited, stack, 0, orderList, -1)) {
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
        int src, List<Integer> orderList, int parent) {
        
        visited[src] = true;
        stack[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (cycle(graph, visited, stack, neighbor, orderList, src)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        orderList.add(src);
        stack[src] = false;
        return false;
    }
}

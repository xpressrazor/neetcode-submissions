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

        Set<Integer> visited = new HashSet<>();

        if (cycle(graph, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean cycle(List<List<Integer>> graph, Set<Integer> visited, int src, int parent) {
        
        if (visited.contains(src)) {
            return true;
        }

        visited.add(src);

        for (int neighbor : graph.get(src)) {
            if (neighbor == parent) {
                continue;
            }

            if (cycle(graph, visited, neighbor, src)) {
                return true;
            }
        }

        return false;
    }
}

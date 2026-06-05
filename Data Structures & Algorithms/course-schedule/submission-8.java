class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && cycle(graph, i, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    private boolean cycle(List<List<Integer>> graph, int src, boolean[] visited, boolean[] stack) {
        visited[src] = true;
        stack[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (cycle(graph, neighbor, visited, stack)) {
                    return true;
                }
            } else if (stack[neighbor]) {
                return true;
            }
        }

        stack[src] = false;
        return false;
    }
}

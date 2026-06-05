class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // directed
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, graph, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCycle(int src, List<List<Integer>> graph, boolean[] visited, boolean[] stack) {
        visited[src] = true;
        stack[src] = true;

        for (int n : graph.get(src)) {
            if (!visited[n]) {
                if (isCycle(n, graph, visited, stack)) {
                    return true;
                }
            } else if (stack[n]) {
                return true;
            }
        }

        stack[src] = false;
        return false;
    }
}
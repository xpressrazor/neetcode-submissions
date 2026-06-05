class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        List<Integer> orderList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && cycle(graph, visited, stack, i, orderList)) {
                break;
            }
        }

        if (orderList.size() != numCourses) {
            return new int[] {};
        } else {
            int[] output = new int[orderList.size()];
            for (int i = 0; i < output.length; i++) {
                output[i] = orderList.get(i);
            }

            return output;
        }
    }

    private boolean cycle(List<List<Integer>> graph, boolean[] visited, boolean[] stack, int src, 
        List<Integer> orderList) {
        
        visited[src] = true;
        stack[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (cycle(graph, visited, stack, neighbor, orderList)) {
                    return true;
                }
            } else if (stack[neighbor]) {
                return true;
            }
        }

        orderList.add(src);
        stack[src] = false;
        return false;
    }
}

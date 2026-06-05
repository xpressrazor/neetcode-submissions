class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);

            for (int neighbor : graph.get(cur)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }


        if (list.size() == numCourses) {
            int[] output = new int[numCourses];
            
            Collections.reverse(list);
            
            for (int i = 0; i < numCourses; i++) {
                output[i] = list.get(i);
            }

            return output;
            
        } else {
            return new int[0];
        }
    }
}

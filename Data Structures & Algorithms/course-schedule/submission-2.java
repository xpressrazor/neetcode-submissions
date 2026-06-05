class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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

        int finish = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            finish++;

            for (int n : graph.get(cur)) {
                indegree[n]--;

                if (indegree[n] == 0) {
                    queue.add(n);
                }
            }
        }

        return finish == numCourses;
    }
}

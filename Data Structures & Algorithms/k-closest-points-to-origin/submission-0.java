class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];

            if (queue.size() < k) {
                queue.add(new int[] {distance, point[0], point[1]});
            } else if (queue.peek()[0] > distance) {
                queue.poll();
                queue.add(new int[] {distance, point[0], point[1]});
            }
        }

        int[][] res = new int[k][2];
        int ptr = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res[ptr++] = new int[] {cur[1], cur[2]};
        }

        return res;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length;
        int[] output = new int[n-k+1];

        for (int i = 0; i < n; i++) {
            pq.add(new int[] {nums[i], i});

            if (i + 1 - k >= 0) {
                while (!pq.isEmpty() && pq.peek()[1] < i-k+1) {
                    pq.poll();
                }

                output[i-k+1] = pq.peek()[0];
            }
        }

        return output;
    }
}

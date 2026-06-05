class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n-k+1];

        int i = 0, j = 0;
        Deque<Integer> deque = new ArrayDeque<>(); // monotonic decreasing

        while (j < n) {
            while (!deque.isEmpty() && deque.peekFirst() < j - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                deque.pollLast();
            }

            deque.offerLast(j);

            if (j - k + 1 >= 0) {
                output[j-k+1] = nums[deque.peekFirst()];
            }
            
            j++;
        }

        return output;
    }
}

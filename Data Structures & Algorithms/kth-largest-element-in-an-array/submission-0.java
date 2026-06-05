class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        return queue.peek();
    }
}

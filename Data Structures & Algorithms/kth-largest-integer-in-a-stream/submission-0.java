class KthLargest {
    Queue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.add(num);
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}

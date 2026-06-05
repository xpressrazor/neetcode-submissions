class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int key : freqMap.keySet()) {
            int f = freqMap.get(key);

            pq.offer(new int[]{f, key});
            if (pq.size() > k) pq.poll();
        }

        int n = pq.size();
        int[] result = new int[n];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll()[1];
        }

        return result;
    }
}

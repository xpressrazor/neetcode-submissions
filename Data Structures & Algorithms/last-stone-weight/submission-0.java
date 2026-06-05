class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            if (first > second) {
                pq.add(first - second);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}

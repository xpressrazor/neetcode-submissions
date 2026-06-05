class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        /*
            MinHeap
            1. Sort intervals by start time
            2. Create minHeap <width, endtime>, Map<query, width>
            3. Get sorted copy of queries (without modifying the original)

            4. Add all intervals with start lte query to minHeap
            5. Remove all intervals with end lt query from minHeap
            6. Add query, width of top of queue to result map
            7. populate result array using the result map

            O(mlogm + nlogn), O(m + n) 
        */

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> resultMap = new HashMap<>();

        int[] sortedqueries = Arrays.stream(queries).sorted().toArray();

        int k = 0, m = intervals.length;

        for (int q : sortedqueries) {
            while (k < m && intervals[k][0] <= q) {
                pq.add(new int[] {intervals[k][1] - intervals[k][0] + 1, intervals[k][1]});
                k++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            resultMap.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = resultMap.get(queries[i]);
        }

        return result;
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        /*
            MinHeap (O(nlogn + mlogm), O(m + n))

            1. Sort intervals by start time
            2. Create min heap with width and end index and map to store query and width
            3. Get sorted copy of queries
            4. Add all intervals, that have start time lte to query
            5. Remove all intervals that have end time lt query
            6. Add query, width to map
            7. Use this list to populate result array
        */

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> resultMap = new HashMap<>();

        int[] sortedquery = Arrays.stream(queries).sorted().toArray();
        int i = 0, m = intervals.length;

        for (int q : sortedquery) {
            while (i < m && intervals[i][0] <= q) {
                pq.add(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            resultMap.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        int n = queries.length;
        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            result[j] = resultMap.get(queries[j]);
        }

        return result;
    }
}

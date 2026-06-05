class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> resultMap = new HashMap<>();

        int i = 0;
        
        // don't sort the original array, only get sorted copy
        for (int query : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= query) {
                int l = intervals[i][0];
                int r = intervals[i][1];

                minHeap.offer(new int[] {r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            resultMap.put(query, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] result = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            result[j] = resultMap.get(queries[j]);
        }

        return result;
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]> events = new ArrayList<>();

        // time, type, range, index
        for (int i = 0; i < intervals.length; i++) {
            events.add(new int[] {intervals[i][0], 0, intervals[i][1] - intervals[i][0] + 1, i});
            events.add(new int[] {intervals[i][1], 2, intervals[i][1] - intervals[i][0] + 1, i});
        }

        // query time, 1 interval, index
        for (int i = 0; i < queries.length; i++) {
            events.add(new int[] {queries[i], 1, i});
        }

        // Sort by time and type
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        // Min heap storing [size, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] inactive = new boolean[intervals.length];

        for (int[] event : events) {
            if (event[1] == 0) {  // interval start
                pq.offer(new int[] {event[2], event[3]});
            } else if (event[1] == 2) {  // interval end
                inactive[event[3]] = true;
            } else {  // query (type 1)
                while (!pq.isEmpty() && inactive[pq.peek()[1]]) {
                    pq.poll();
                }

                if (!pq.isEmpty()) {
                    result[event[2]] = pq.peek()[0];
                }
            }
        }

        return result;
    }
}

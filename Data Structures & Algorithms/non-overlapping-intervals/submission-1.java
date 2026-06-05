class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals.length - dfs(intervals, 0, -1);
    }

    private int dfs(int[][] intervals, int i, int prev) {
        if (i == intervals.length) {
            return 0;
        }

        int res = dfs(intervals, i + 1, prev);

        if (prev == -1 || intervals[prev][1] <= intervals[i][0]) {
            res = Math.max(res, 1 + dfs(intervals, i + 1, i));
        }

        return res;
    }
}

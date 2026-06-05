class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int index = binarySearch(i, intervals[i][0], intervals);

            if (index == 0) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.max(dp[i-1], 1 + dp[index - 1]);
            }
        }

        return n - dp[n-1];
    }

    private int binarySearch(int r, int target, int[][] intervals) {
        int l = 0;

        while (l <= r) {
            int m = l + ((r - l) >> 1);

            if (intervals[m][1] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}

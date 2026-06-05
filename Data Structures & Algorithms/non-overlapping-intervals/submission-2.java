class Solution {
    private int[] memo;
    int n;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        n = intervals.length;
        
        memo = new int[n];
        Arrays.fill(memo, -1);

        return n - dfs(intervals, 0);   
    }

    private int dfs(int[][] intervals, int i) {
        if (i == intervals.length) {
            return 0;
        } else if (memo[i] != -1) {
            return memo[i];
        }

        int res = 1;

        for (int j = i + 1; j < n; j++) {
            if (intervals[i][1] <= intervals[j][0]) {
                res = Math.max(res, 1 + dfs(intervals, j));
            }
        }

        return memo[i] = res;
    }
}

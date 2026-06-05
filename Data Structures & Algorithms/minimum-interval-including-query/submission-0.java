class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int ptr = 0;

        for (int query : queries) {
            int cur = -1;

            for (int[] interval : intervals) {
                int l = interval[0];
                int r = interval[1];

                if (l <= query && query <= r) {
                    if (cur == -1 || (r - l + 1) < cur) {
                        cur = r - l + 1;
                    }
                }
            }

            result[ptr++] = cur;
        }

        return result;
    }
}

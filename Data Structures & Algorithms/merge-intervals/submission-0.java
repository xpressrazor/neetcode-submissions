class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                list.add(prev);
                prev = intervals[i];
            }
        }

        list.add(prev);

        int[][] result = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

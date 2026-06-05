/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();

        for (Interval interval : intervals) {
            time.add(new int[] {interval.start, 1});
            time.add(new int[] {interval.end, -1});
        }

        // Could also use Collections.sort. time cannot be null
        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0, count = 0;

        for (int[] t : time) {
            count += t[1];
            res = Math.max(res, count);
        }

        return res;
    }
}

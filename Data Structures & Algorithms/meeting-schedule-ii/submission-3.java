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
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, count = 0, i = 0, j = 0;

        while (i < n) {
            if (start[i] < end[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}

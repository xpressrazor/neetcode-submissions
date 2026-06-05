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
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }

            minHeap.add(interval.end);
        }

        return minHeap.size();
    }
}

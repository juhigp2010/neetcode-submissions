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
    public boolean canAttendMeetings(List<Interval> intervals) {
if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // 1. Sort by start time using a Comparator
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 2. Compare each meeting's start with the previous meeting's end
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            Interval previous = intervals.get(i - 1);

            // If the current meeting starts BEFORE the previous one ends, overlap!
            if (current.start < previous.end) {
                return false;
            }
        }

        // No overlaps found
        return true;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       if (intervals.length == 0) return 0;

        // 1. Sort by end time (the greedy choice)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        // 2. Keep track of the end of the last "kept" interval
        int end = intervals[0][1];
       for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Overlap found! "Remove" this one.
                count++;
            } else {
                // No overlap! Update our end marker to this new interval.
                end = intervals[i][1];
            }
        }       

        return count;
    }
    
}

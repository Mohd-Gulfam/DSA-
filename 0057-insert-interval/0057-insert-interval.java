import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> ans = new ArrayList<>();

        int start2 = newInterval[0];
        int end2 = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {

            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            // No overlap and current interval is before newInterval
            if (end1 < start2) {
                ans.add(new int[]{start1, end1});
            }

            // No overlap and current interval is after newInterval
            else if (start1 > end2) {
                ans.add(new int[]{start2, end2});

                // Add remaining intervals
                for (int j = i; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }

                return ans.toArray(new int[ans.size()][]);
            }

            // Overlap
            else {
                start2 = Math.min(start2, start1);
                end2 = Math.max(end2, end1);
            }
        }

        // Add newInterval at the end
        ans.add(new int[]{start2, end2});

        return ans.toArray(new int[ans.size()][]);
    }
}
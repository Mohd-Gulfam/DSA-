class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        // Step 2: Add the first interval
        ans.add(intervals[0]);

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Last interval in answer
            int[] last = ans.get(ans.size() - 1);

            // If intervals overlap
            if (intervals[i][0] <= last[1]) {

                // Merge by updating the ending point
                last[1] = Math.max(last[1], intervals[i][1]);
            }
            else {
                // No overlap, add new interval
                ans.add(intervals[i]);
            }
        }

        // Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}
    

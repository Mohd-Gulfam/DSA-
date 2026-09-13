class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {

            // Maximum subarray - Kadane
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray - Kadane
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Normal maximum vs circular maximum
        int circularSum = total - minSum;

        return Math.max(maxSum, circularSum);
    }
}
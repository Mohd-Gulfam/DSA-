class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i<nums.length; i++){
            int v1 = nums[i];
            currSum += nums[i];
            currSum = Math.max(v1, currSum);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
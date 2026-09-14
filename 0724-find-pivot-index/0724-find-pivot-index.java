class Solution {
    public int pivotIndex(int[] nums) {

        int sum = 0;
        int left = 0;
        int right = 0;

        // Total sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // Check pivot
        for (int i = 0; i < nums.length; i++) {

            right = sum - nums[i] - left;

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}
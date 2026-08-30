class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Window me right wala element add
            sum += nums[right];

            // Jab sum target ke equal ya greater ho
            while (sum >= target) {

                // Current window ki minimum length check
                minLen = Math.min(minLen, right - left + 1);

                // Left element remove
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
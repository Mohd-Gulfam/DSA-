class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int v1 = nums[i];
            int v2 = max * nums[i];
            int v3 = min*nums[i];
            max = Math.max(v1, Math.max(v2,v3));
            min = Math.min(v1, Math.min(v2,v3));
            ans = Math.max(ans, Math.max(min,max));
            
            
        }

        return ans;
    }
}
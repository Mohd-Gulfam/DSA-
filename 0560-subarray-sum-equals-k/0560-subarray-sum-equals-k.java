import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 occurs once
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // current prefix sum
            prefix += nums[i];

            // required previous prefix
            int required = prefix - k;

            // if required prefix exists
            count += map.getOrDefault(required, 0);

            // store current prefix
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}
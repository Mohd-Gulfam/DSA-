import java.util.HashMap;

class Solution {
    public int subarraySum(int[] arr, int k) {

        int n = arr.length;
        int count = 0;

        int[] prefix = new int[n];
        prefix[0] = arr[0];

        // Build prefix sum array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int j = 0; j < n; j++) {

            // Case 1: Subarray starts from index 0
            if (prefix[j] == k) {
                count++;
            }

            // Case 2: Check if (prefix[j] - k) exists
            int val = prefix[j] - k;

            if (hm.containsKey(val)) {
                count += hm.get(val);
            }

            // Store current prefix sum
            if (hm.containsKey(prefix[j])) {
               hm.put(prefix[j], hm.get(prefix[j]) + 1);
            } else {
               hm.put(prefix[j], 1);
            }
        }

        return count;
    }
}
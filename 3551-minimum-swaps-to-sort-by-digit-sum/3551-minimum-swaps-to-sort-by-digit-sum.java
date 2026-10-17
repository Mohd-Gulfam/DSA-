import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store number and its digit sum
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int num = nums[i];

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Find minimum swaps using cycle detection
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
        }

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == sorted[i]) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = index.get(sorted[j]);
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}
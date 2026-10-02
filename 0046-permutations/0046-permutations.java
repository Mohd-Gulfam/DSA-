import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> ans) {

        // If current permutation contains all elements
        if (current.size() == nums.length) {

            // Add a copy
            ans.add(new ArrayList<>(current));

            return;
        }

        // Try every element
        for (int i = 0; i < nums.length; i++) {

            // If already used, don't select it again
            if (used[i]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, used, current, ans);

            // Undo choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
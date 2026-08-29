class Solution {

    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean direction = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                // slow ka next
                int nextSlow = nextIndex(nums, slow, direction);

                // fast ka first next
                int nextFast = nextIndex(nums, fast, direction);

                if (nextSlow == -1 || nextFast == -1) {
                    break;
                }

                // fast ka second next
                nextFast = nextIndex(nums, nextFast, direction);

                if (nextFast == -1) {
                    break;
                }

                slow = nextSlow;
                fast = nextFast;

                // Cycle found
                if (slow == fast) {

                    // self-loop allowed nahi hai
                    if (slow == nextIndex(nums, slow, direction)) {
                        break;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int index, boolean direction) {

        // Direction change
        if ((nums[index] > 0) != direction) {
            return -1;
        }

        int n = nums.length;

        int next = (index + nums[index]) % n;

        if (next < 0) {
            next += n;
        }

        // Same index means cycle of length 1
        if (next == index) {
            return -1;
        }

        return next;
    }
}
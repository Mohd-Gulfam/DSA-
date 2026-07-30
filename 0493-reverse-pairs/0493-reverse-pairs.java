class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int low, int high) {

        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Merge
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right])
                temp[k++] = nums[left++];
            else
                temp[k++] = nums[right++];
        }

        while (left <= mid)
            temp[k++] = nums[left++];

        while (right <= high)
            temp[k++] = nums[right++];

        for (int i = 0; i < temp.length; i++)
            nums[low + i] = temp[i];
    }
}
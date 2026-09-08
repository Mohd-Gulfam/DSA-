class Solution {
    public void sortColors(int[] arr) {
        // int[] freq = new int[3];

        // for (int i = 0; i < nums.length; i++) {
        //     freq[nums[i]]++;
        // }
        // int k = 0;
        // for (int i = 0; i < freq.length; i++) {
        //     while (freq[i]-- > 0) {
        //         nums[k++] = i;
        //     }

        // }
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
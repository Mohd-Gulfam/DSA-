class Solution {
    public double findMaxAverage(int[] arr, int k) {
        double windowSum = 0;
        for(int i = 0; i<k; i++){
            windowSum += arr[i];
        }
        
        double maxSum = windowSum;
        for(int right = k; right<arr.length; right++){
            windowSum += arr[right];
            windowSum -= arr[right - k];
             
            maxSum = Math.max(maxSum, windowSum);

        }

        return maxSum/k;
    }
}
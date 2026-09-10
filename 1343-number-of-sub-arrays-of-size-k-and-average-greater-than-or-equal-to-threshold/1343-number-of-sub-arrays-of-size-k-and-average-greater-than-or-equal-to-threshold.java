class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windoSum = 0;
        for(int i=0; i<k; i++){
            windoSum += arr[i];
           
        }
         if(windoSum/k >= threshold){
                count++;
            }

        
        for(int right = k; right<arr.length; right++){
            windoSum += arr[right];
            windoSum -= arr[right-k];
            if(windoSum/k >= threshold){
                count++;
            }
        }
        return count;
        
    }
}
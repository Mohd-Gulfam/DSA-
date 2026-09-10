class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        for(int i =0; i<customers.length; i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
        }

        int windowSum = 0;
        for(int i = 0; i<minutes; i++){
            if(grumpy[i] == 1){
                windowSum += customers[i];
            }
        }
        int maxSum = windowSum;
        for(int right = minutes; right<customers.length; right++){
            if(grumpy[right] == 1){
                windowSum += customers[right];
            }
            if(grumpy[right - minutes] == 1){
                windowSum -= customers[right - minutes];
            }

            maxSum = Math.max(maxSum, windowSum);
        }
        return satisfied+maxSum;
        
    }
}
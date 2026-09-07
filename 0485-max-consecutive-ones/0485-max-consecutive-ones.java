class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum =0;
        int max_sum =0;
       for(int i =0; i<nums.length; i++){
              if(nums[i] == 1){
                sum++;
                max_sum = Math.max(sum,max_sum);

              }else{
                sum =0;
              }
              

       } 
       return max_sum;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int start = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] != nums[start] ){
                start += 1;
                nums[start] = nums[i];


            }
        }
        return start+1;
    }
}
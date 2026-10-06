class Solution {
    public int helper(int[] arr, int target, int lo, int hi){
        if(lo>hi){
            return -1;
        }
        int mid = lo +(hi-lo)/2;
        if(arr[mid] == target) return mid;
        else if(arr[mid]> target) return helper(arr,target,lo,mid-1);
        else return helper(arr,target,mid+1,hi);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        return helper(nums, target, 0, n-1);
        
    }
}
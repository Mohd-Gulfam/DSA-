class Solution {
    public boolean isPalindrome(int nums ) {
        int orignal = nums;
        int reverse = 0;
        while(nums>0){
            int digit = nums%10;
            reverse = reverse * 10 + digit;
            nums = nums/10;
        }
        if(reverse == orignal){
            return true;
        }else{
            return false;
        }
        
    }

    
}
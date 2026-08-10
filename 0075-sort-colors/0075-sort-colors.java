class Solution {
    public void sortColors(int[] nums) {
     int c_0 = 0;
     int c_1 = 0;
     int c_2 = 0;

     for(int i =0; i< nums.length; i++){
        if(nums[i] == 0) {
            c_0++;
        } else if(nums[i] == 1){
            c_1++;
        }  else {
            c_2++;
        }
     }

        int k =0;
while(c_0-- > 0){
    nums[k++] = 0;
}
while(c_1-- > 0){
    nums[k++] = 1;
}

while(c_2-- > 0){
    nums[k++] = 2;
}


     }

  
    
}
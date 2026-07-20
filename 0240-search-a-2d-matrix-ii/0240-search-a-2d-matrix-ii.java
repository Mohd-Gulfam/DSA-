class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m =  mat.length , n = mat[0].length;
        int r = 0, c= n-1;
        while(r<m && c>= 0){
            if(target == mat[r][c]){
                return true;
            }else if( target > mat[r][c]){
                r++;
            }else{
                c--;
            }
        }
        return false;
        
    }
}
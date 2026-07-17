class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;
        int rep =-1 ;
        int mis =-1;
        int actualSum = 0;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])){
                    rep = grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int expectedSum = (n*n)*(n*n +1)/2;
        mis = expectedSum + rep - actualSum;

        return new int[] {rep,mis};

        
    }
}
class Solution {
    public boolean exist(char[][] arr, String word) {
        int row = arr.length;
        int col = arr[0].length;

        // travel all row and col
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(dfs(arr,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean dfs(char arr[][], String word, int row, int col, int idx){
        // base case
        if(idx == word.length()){
            return true;
        }
        // invalid case 
        if(row<0 ||row>=arr.length || col<0 ||col>= arr[0].length || arr[row][col] != word.charAt(idx)){
            return false;
        }

        // save original 
        char temp = arr[row][col];

        // mark as visite
        arr[row][col] = '#';

        // call dfs
        boolean found = dfs(arr ,word, row-1, col, idx+1)||
                        dfs(arr, word, row+1, col, idx+1)||
                        dfs(arr, word, row, col-1, idx+1)||
                        dfs(arr, word, row, col+1, idx+1);

        // restore original
        arr[row][col] = temp;
        return found;
    }
}
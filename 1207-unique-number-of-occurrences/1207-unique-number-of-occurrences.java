class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int[] freq = new int[2001];

        for(int i = 0; i<n; i++){
            freq[arr[i]+1000]++;
        }

        boolean[] used = new boolean[n+1];

        for(int count: freq){
            if(count>0){
                if(used[count]){
                    return false;
                }
                used[count] = true;
            }
        }
        return true;
        
    }
}
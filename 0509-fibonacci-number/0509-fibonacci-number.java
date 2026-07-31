class Solution {
    public int febo(int n, int[] dp){
        if(n<= 1) return n;
        if(dp[n] != 0 ) return dp[n];
        int ans = febo(n-1,dp)+febo(n-2,dp);
        dp[n] = ans;
        return ans;
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        return febo(n,dp);
        
    }
}
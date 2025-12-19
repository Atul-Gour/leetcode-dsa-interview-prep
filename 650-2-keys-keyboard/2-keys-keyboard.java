class Solution {
    static int GCD (int n ){
        if(n <= 1)return 1;

        for(int i = 2 ; i*i <= n ;i++ ){
            if(n % i == 0)return n/i;
        }
        return 1;
    }
    public int minSteps(int n) {
        int dp[] = new int[n+1];
        dp[1] = 0;

        for(int i = 2 ;i <= n ;i++ ){
            int used = GCD(i);
            dp[i] = dp[used] + i/used;
        }
        return dp[n];
    }
}
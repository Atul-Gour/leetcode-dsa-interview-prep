class Solution {
    private long currCost( int[] prefixOneCount , int i , int j , int encCost, int flatCost ){
        int sensitiveCount = prefixOneCount[j + 1] - prefixOneCount[i];
        int cost = 0;
        if( sensitiveCount == 0 )return flatCost;
        else return (long)(j - i + 1) * sensitiveCount * encCost;
    }
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int prefixOneCount[] = new int[n+1];

        // count levels
        int m = 0, tmp = n;
        while( tmp % 2 == 0 ){ tmp /= 2; m++; }

        // jagged dp: dp[len][i] instead of dp[i][j]
        long[][] dp = new long[n + 1][];
        dp[1] = new long[n]; // single chars, length=1

        for( int i = 1 ; i <= n ; i++ ){
            if( s.charAt(i-1) == '1' )
                prefixOneCount[i] = prefixOneCount[i-1] + 1;
            else prefixOneCount[i] = prefixOneCount[i-1];
        }

        for( int i = 0 ; i < n ; i++ ){
            if( s.charAt(i) == '1' )
                dp[1][i] = encCost;
            else dp[1][i] = flatCost;
        }

        for( int len = 2 ; len <= n ; len++ ){
            if( n % len != 0 ) continue; // only valid segment lengths
            dp[len] = new long[n / len];
            for( int i = 0 ; i < n / len ; i++ ){
                int l = i * len;
                int r = l + len - 1;
                long wholeCost = currCost( prefixOneCount , l , r , encCost, flatCost );
                long separationCost = Long.MAX_VALUE;
                if( len % 2 == 0 ){
                    separationCost = dp[len/2][2*i] + dp[len/2][2*i+1];
                }
                dp[len][i] = Math.min( wholeCost , separationCost );
            }
        }
        return dp[n][0];
    }
}
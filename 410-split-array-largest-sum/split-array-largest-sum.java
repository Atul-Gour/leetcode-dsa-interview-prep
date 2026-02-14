class Solution {
    private long solve( int index , int current , long prefix[] , long[][] dp){
        int n = dp[0].length;
        int k = dp.length;

        if( index >= n ){
            return Integer.MIN_VALUE;
        }

        if( dp[current][index] != -1 ) return dp[current][index];
        if( current == k - 1 ){
            return dp[current][index] = prefix[n-1] - prefix[index-1];
        }

        long ans = Integer.MAX_VALUE;
        for( int i = index ; i < n ; i++ ){
            long curr = prefix[i] - prefix[index-1];
            long futureMax = solve( i + 1 , current + 1 , prefix , dp );
            if( futureMax == Integer.MIN_VALUE )break;
            ans = Math.min( ans , Math.max( curr , futureMax )  );
        }

        return dp[current][index] = ans;

    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[k][n + 1];
        long prefix[] = new long[n + 1];

        for( int i = 1 ; i <= n ; i++ ){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for( long[] d : dp ){
            Arrays.fill( d , -1 );
        }

        return (int)solve( 1 , 0 , prefix , dp);
    }
}
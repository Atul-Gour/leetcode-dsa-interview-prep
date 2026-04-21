class Solution {

    public boolean canCross(int[] stones) {
        if( stones[1] != 1 )return false;
        int n = stones.length;

        HashMap<Integer , Integer> elementIndex = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) elementIndex.put( stones[i] , i );

        boolean[][] dp = new boolean[n][n+1];
        Arrays.fill( dp[n-1] , true );

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = 1 ; j <= n ; j++ ){
                if( !dp[i][j]  )continue;

                int prev = stones[i] - j;

                if( elementIndex.containsKey( prev ) ){
                    int k = elementIndex.get(prev);

                    if (j - 1 > 0) dp[k][j - 1] = true;
                    if (j > 0)     dp[k][j]     = true;
                    if (j + 1 <= n) dp[k][j + 1] = true;
                }
            }
        }
        
        return dp[1][1];
    }
}
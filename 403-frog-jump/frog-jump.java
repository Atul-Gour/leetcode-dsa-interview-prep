class Solution {

    int[][] dp;
    int[] stones ;

    boolean find( int index , int k ){
        int n = stones.length;
        if( index == n-1 )return true;
        if( index >= n ) return false;


        for( int i = index + 1 ; i < n ; i++ ){
            int jumpNeeded = stones[i] - stones[index];
            if( jumpNeeded == k || jumpNeeded == k - 1 || jumpNeeded == k + 1 ){
                if( dp[i][jumpNeeded] == -1  )continue;
                dp[i][jumpNeeded] = 1;
                if( find( i , jumpNeeded ) )return true;
                dp[i][jumpNeeded] = -1;
            }
            if( jumpNeeded > k + 1 )return false;
        }

        return false;
    }

    public boolean canCross(int[] stones) {
        if( stones[1] != 1 )return false;
        int n = stones.length;

        this.stones = stones;
        this.dp = new int[10000][n];
        
        return find( 1 , 1 );
    }
}
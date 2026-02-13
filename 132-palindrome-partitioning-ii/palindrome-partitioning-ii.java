class Solution {

    private int find( int index , boolean[][] dp , Integer[] memo ){
        int n = dp.length;
        if( index == n ) return -1;
        if( memo[index] != null )return memo[index];

        int ans = Integer.MAX_VALUE;

        for( int i = index ; i < n ; i++ ){
            if( dp[index][i] ){
                ans = Math.min( ans , 1 + find( i + 1 , dp , memo ) );
            }
        }

        return memo[index] = ans;    

    }
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start <= 2 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                    }
                }
            }
        }

        Integer memo[] = new Integer[n];
        return find( 0 , dp , memo );
    }
}
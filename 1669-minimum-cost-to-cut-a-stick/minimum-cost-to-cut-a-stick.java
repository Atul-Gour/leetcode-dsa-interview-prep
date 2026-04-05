class Solution {

    public int minCost(int n, int[] cuts) {
        
        Arrays.sort( cuts );
        int arr[] = new int[cuts.length + 2];
        int nn = arr.length;

        for( int i = 0 ; i < cuts.length ; i++ ){
            arr[ i + 1 ] = cuts[i];
        }
        arr[ nn - 1 ] = n;

        int dp[][] = new int[nn][nn];

        for( int len = 2 ; len < nn ; len++ ){
            for( int i = 1 ; i + len - 1 < nn ; i++ ){
                int j = i + len - 1;

                int ans = Integer.MAX_VALUE;
                for( int k = i ; k < j ; k++ ){

                    int cost =  dp[i][k] +
                                dp[k + 1][j] +
                                arr[j] - arr[i - 1];

                    ans = Math.min( ans , cost );
                }
                dp[i][j] = ans;

            }
        }

        return dp[1][nn - 1];
    }
}
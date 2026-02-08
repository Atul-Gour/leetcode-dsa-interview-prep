class Solution {

    public long maxScore(int[] nums1, int[] nums2, int pairs) {

        int n = nums1.length;
        int m = nums2.length;

        long[][][] memo = new long[n + 1][m + 1][pairs + 1];
        
        for( int i = 0 ; i <= n ; i++ ){
            for( int j = 0 ; j <= m ; j++ ){
                for( int k = 0 ; k <= pairs ; k++ ){
                    if(k == pairs){
                        memo[i][j][k] = 0;
                    }
                    else if(i == n || j == m){
                        memo[i][j][k] = Long.MIN_VALUE / 2;
                    }
                    else{
                        memo[i][j][k] = Long.MIN_VALUE ;
                    }
                }
            }
        }
        

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = m - 1 ; j >= 0 ; j-- ){
                for( int k = pairs - 1 ; k >= 0 ; k-- ){
                    
                    long skip1 = memo[i+1][j][k];

                    long skip2 = memo[i][j+1][k];

                    long take = (long) nums1[i] * nums2[j] + memo[i+1][j+1][k+1];

                    memo[i][j][k] = Math.max(take, Math.max(skip1, skip2));
                    
                }
            }
        }

        return memo[0][0][0];
    }
}

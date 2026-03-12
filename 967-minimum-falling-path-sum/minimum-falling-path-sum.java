class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = Arrays.copyOf(matrix[0], matrix[0].length);
        int dp2[] = new int[n];

        for( int i = 1 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                int left = j-1 >= 0 ? dp[j-1] : Integer.MAX_VALUE;
                int right = j+1 < n ? dp[j+1] : Integer.MAX_VALUE;
                dp2[j] = Math.min( dp[j] , Math.min(left , right) ) + matrix[i][j];
            }
            int[] temp = dp2;
            dp2 = dp;
            dp = temp;
        }

        int ans = Integer.MAX_VALUE;

        for( int i = 0 ; i < n ; i++ ){
            ans = Math.min( dp[i] , ans );
        }

        return ans;
    }
}
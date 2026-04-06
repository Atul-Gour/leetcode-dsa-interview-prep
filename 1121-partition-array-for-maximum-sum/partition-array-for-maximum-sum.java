class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            int maxValue = 0;
            int ans = 0;

            for( int step = 0 ; step < k   ; step++ ){
                int mid = i + step;
                if( mid >= n )continue;
                maxValue = Math.max( maxValue , arr[mid] );

                int profit = ((step + 1) * maxValue) + dp[mid + 1];
                ans = Math.max( profit , ans );
            }

            dp[i] = ans;
        }

        return dp[0];
    }
}
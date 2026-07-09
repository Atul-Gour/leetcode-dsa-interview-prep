class Solution {

    private int findElement( int[] nums , int high , int target ){
        int low = 0;

        while( low < high ){
            int mid = low + (high - low)/2;

            if( nums[mid] >= target ){
                high = mid;
            }
            else low = mid + 1;
        }

        return low;
    }

    private boolean find( int[] query , int[] nums , int maxDiff, int dp[] ){
        
        int a = query[0]; int b = query[1];

        if( a == b ) return true;
        else if( a > b ) {
            query[0] = b;
            query[1] = a;
            return find( query , nums , maxDiff, dp );
        }
        else if( dp[b] <= a ) return true;
        else return false;
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int queriesLength = queries.length;
        boolean[] ans = new boolean[queriesLength];
        int[] dp = new int[n];

        for( int i = 1 ; i < n ; i++ ){
            dp[i] = i;
            int minIndex = findElement(nums , i , nums[i] - maxDiff);
            dp[i] = dp[minIndex];
        }

        for( int i = 0 ; i < queriesLength ; i++ ){
            ans[i] = find( queries[i] , nums , maxDiff , dp );
        }

        return ans;
    }
}

























class Solution {

    private int findElement( int[] nums , int high , int target ){
        int low = 0;
        int ans = -1;

        while( low <= high ){
            int mid = low + (high - low)/2;

            if( nums[mid] >= target ){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }

    private boolean find( int[] query , int[] nums , int maxDiff, int dp[] ){
        if( query[0] == query[1] ) return true;
        else if( query[0] > query[1] ) {
            int temp = query[0];
            query[0] = query[1];
            query[1] = temp;
            return find( query , nums , maxDiff, dp );
        }
        else if( dp[query[1]] <= query[0] ) return true;
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

























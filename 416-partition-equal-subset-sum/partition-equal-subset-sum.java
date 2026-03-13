class Solution {

    private HashSet<Integer> helper( int nums[] , int left , int right ){
        int n = right - left + 1;
        int sum = 0;
        for( int i = 0 ; i < n ; i++ ) sum += nums[i + left];

        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[left]);
        boolean[][] dp = new boolean[n][sum + 1];

        dp[0][nums[left]] = true;
        for( int i = 0 ; i < n ; i++ ) dp[i][0] = true;
        
        for( int i = 1 ; i < n ; i++ ){
            for( int j = 0 ; j <= sum ; j++ ){
                if( j < nums[i + left] ) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][ j - nums[i + left] ] || dp[i-1][j];

                if( dp[i][j] ) set.add( j );
            }
        }

        return set;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if( n <= 1 ) return false;
        int sum = 0;
        for( int ele : nums ) sum += ele;

        if( sum % 2 != 0 )return false;
        int half = n / 2;

        HashSet<Integer> set1 = helper( nums , 0 , half - 1 );
        HashSet<Integer> set2 = helper( nums , half , n - 1 );

        int target = sum/2;

        for( int a : set1 ){
            if( set2.contains( target - a ) ) return true;
        }
        return false;
    }
}
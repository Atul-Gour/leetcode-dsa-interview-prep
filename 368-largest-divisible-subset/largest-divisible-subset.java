class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length + 1;
        int[] nums = new int[n];
        for( int i = 1 ; i < n ; i++ ) nums[i] = arr[i-1];
        nums[0] = 1;


        Arrays.sort( nums );
        int[][] dp = new int[n + 1][n + 1];
        List<Integer> ans = new ArrayList<>();

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = i-1 ; j >= 0 ; j-- ){
                int skip = dp[i+1][j];

                int take = 0;
                if( (nums[i] % nums[j]) == 0 || (nums[j] % nums[i]) == 0 ){
                    take = 1 + dp[i+1][i];
                }
                dp[i][j] = Math.max( take , skip );
            }
        }

        int i = 1 , j = 0;

        while( i < n ){
            int skip = dp[i+1][j];

            int take = 0;
            if( (nums[i] % nums[j]) == 0 || (nums[j] % nums[i]) == 0 ){
                take = 1 + dp[i+1][i];
            }

            if( take > skip ){
                ans.add( nums[i] );
                j = i;
            }

            i++;
        }

        // for( int[] d : dp ){
        //     for( int ele : d ) System.out.print(ele + " ");
        //     System.out.println();
        // }

        return ans;
    }
}
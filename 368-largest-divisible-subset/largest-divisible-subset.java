class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort( nums );
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        List<Integer> ans = new ArrayList<>();

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = i ; j >= 0 ; j-- ){
                int skip = dp[i+1][j];

                int take = 0;
                if( j == 0 || (nums[i] % nums[j - 1]) == 0 ){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j] = Math.max( take , skip );
            }
        }

        int i = 0 , j = 0;

        while( i < n ){
            int skip = dp[i+1][j];

            int take = 0;
            if( j == 0 || (nums[i] % nums[j - 1]) == 0 ){
                take = 1 + dp[i+1][i+1];
            }

            if( take > skip ){
                ans.add( nums[i] );
                j = i+1;
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
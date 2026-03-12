class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] dp = new int[n];

        dp[0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++){
            for(int j = i; j >= 0; j--){

                if(j == 0)
                    dp[j] = dp[j] + triangle.get(i).get(j);

                else if(j == i)
                    dp[j] = dp[j-1] + triangle.get(i).get(j);

                else
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int v : dp) ans = Math.min(ans, v);

        return ans;
    }
}
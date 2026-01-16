class Solution {
    public int maxScore(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;

        int[] dp1 = new int[k + 1];
        int[] dp2 = new int[k + 1];

        for(int i = 1 ; i <= k ; i++ ){
            dp1[i] = nums[i - 1] + dp1[i-1];
        }

        int index = n-1;
        for(int i = 1; i <= k ; i++){
            dp2[i] = nums[index] + dp2[i - 1];
            index--;
        }

        for(int i = 0 ; i <= k ; i++ ){
            ans = Math.max(ans , dp1[i] + dp2[k - i]);
        }

        return ans;        
    }
}
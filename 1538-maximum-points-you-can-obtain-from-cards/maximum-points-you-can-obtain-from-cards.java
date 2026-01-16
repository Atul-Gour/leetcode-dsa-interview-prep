class Solution {
    public int maxScore(int[] nums, int k) {

        int n = nums.length;
        int lSum = 0;
        int rSum = 0;

        for(int i = 0 ; i < k ; i++ ){
            lSum += nums[i];
        }
        
        int ans = lSum;
        int index = n-1;
        for(int i = k-1; i >=0 ; i--){
            
            rSum += nums[index];
            lSum -= nums[i];

            ans = Math.max(ans , rSum + lSum);
            index--;
        }

        return ans;        
    }
}
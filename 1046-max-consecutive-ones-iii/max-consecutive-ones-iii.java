class Solution {
    public int longestOnes(int[] nums, int k) {
        int oneCount = 0;
        int zeroFlipped = 0;
        int n = nums.length;

        int l = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {

            oneCount++;

            if (nums[r] == 0) {
                nums[r] = -1;
                zeroFlipped++;
            }

            while (zeroFlipped > k) {

                if (nums[l] == -1)
                    zeroFlipped--;
                
                if(nums[l] != 0)oneCount--;

                l++;
            }

            ans = Math.max(ans, oneCount);
        }
        return ans;
    }
}
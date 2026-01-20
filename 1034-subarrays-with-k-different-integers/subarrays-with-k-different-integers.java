class Solution {
    public int atMax(int[] nums, int k) {

        int distinct = 0;
        int[] freq = new int[nums.length + 1];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0)
                    distinct--;
                left++;
            }
            if (distinct <= k)
                ans += right - left + 1;

        }
        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMax(nums, k) - atMax(nums, k - 1);
    }
}
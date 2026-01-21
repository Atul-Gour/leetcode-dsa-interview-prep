class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<Long> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            long hash = 0;
            long base = 201;

            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) cnt++;
                if (cnt > k) break;

                hash = hash * base + nums[j];
                set.add(hash);
            }
        }
        return set.size();
    }
}

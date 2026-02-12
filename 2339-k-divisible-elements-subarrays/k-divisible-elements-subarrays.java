class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int divisibleCount = 0;
        HashSet<Long> set = new HashSet<>();
        long base = 201;

        for(int i = 0; i < nums.length; i++){

            long hash = 0;
            divisibleCount = 0;

            for(int j = i; j < nums.length; j++){

                if(nums[j] % p == 0) divisibleCount++;

                if(divisibleCount > k) break;

                hash = hash * base + nums[j] ;
                set.add(hash);
            }
        }

        return set.size();
    }
}

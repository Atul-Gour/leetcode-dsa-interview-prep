class Solution {
    public int countDistinct(int[] nums, int k, int p) {

        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            int divisibleCount = 0;
            ArrayList<Integer> list = new ArrayList<>();

            for(int j = i; j < nums.length; j++){

                if(nums[j] % p == 0) divisibleCount++;

                if(divisibleCount > k) break;

                list.add(nums[j]);
                set.add(new ArrayList<>(list));
            }
        }

        return set.size();
    }
}

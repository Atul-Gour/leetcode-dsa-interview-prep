class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = 0;
        int n = nums.length;        

        for(int i = 0; i < n ; i++ ){
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int j = i ; j < n ; j++){
                int curr = nums[j];
                set.add(curr);
                sum += curr;

                if(set.contains(sum)){
                    ans++;
                }
            }
        }
        return ans;
    }
}
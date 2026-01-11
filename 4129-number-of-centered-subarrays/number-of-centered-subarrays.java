class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int sum = 0, count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            sum = 0;
            set.clear();
            for(int j=i;j<n;j++){
                sum+=nums[j];
                set.add(nums[j]);
                if(set.contains(sum)){
                    count++;
                }
            }   
        }
        return count;
    }
}
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    private void findSubsets(int[] nums ,int index , ArrayList<Integer> curr){
        int n = nums.length;

        if(index >= n){
            ans.add(new ArrayList<>(curr));
            return; 
        }

        curr.add(nums[index]);
        findSubsets(nums , index + 1 , curr);

        curr.remove(curr.size() - 1);
        findSubsets(nums , index + 1 , curr);
    }


    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums , 0 , new ArrayList<>());
        return ans;
    }
}
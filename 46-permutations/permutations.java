class Solution {

    void solve( List<Integer> curr , List<List<Integer>> ans , int[] nums , boolean[] visited){

        for(int i = 0 ; i < nums.length ; i++){

            if(visited[i])continue;
            visited[i] = true;
            curr.add(nums[i]);

            if(curr.size() == nums.length) ans.add( new ArrayList<>(curr));
            else solve ( curr , ans , nums , visited);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;

        boolean[] visited = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();

        solve(new ArrayList<>(), ans , nums , visited);
        
        return ans;
    }
}
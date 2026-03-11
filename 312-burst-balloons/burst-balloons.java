class Solution {

    int[][] memo;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        memo = new int[n + 2][n + 2];

        return solve(arr, 1, n  );
    }

    private int solve(int[] arr, int left, int right){

        if(left > right)
            return 0;

        if(memo[left][right] != 0)
            return memo[left][right];

        int ans = 0;

        for(int k = left ; k <= right; k++){

            int cost =
                    solve(arr, left, k-1) +
                    arr[left - 1] * arr[k] * arr[right + 1] +
                    solve(arr, k+1, right);

            ans = Math.max(ans, cost);
        }

        memo[left][right] = ans;

        return ans;
    }
}
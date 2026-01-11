class Solution {

    public boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }

    private int solve(TreeNode curr){
        if( curr == null )return 0;

        int left = solve(curr.left);
        int right = solve(curr.right);

        if(left == -1 || right == -1)return -1; 

        if(Math.abs(left - right) > 1)return -1;

        return 1 + Math.max(left , right);
    }
}
class Solution {
    int ans = 0;

    private int solve( TreeNode curr ){
        if( curr.left == null && curr.right == null ) return 1;

        int left = -1;
        int right = -1;

        if( curr.left != null ) left = solve( curr.left );
        if( curr.right != null ) right = solve( curr.right );
        
        if( left == 1 || right == 1 ){
            ans++;
            return 2;
        }
        
        if( left == 2 || right == 2 ) return 0;
        if( left == 0 || right == 0 )return 1;

        return 1;
    }
    
    public int minCameraCover(TreeNode root) {
        ans = 0;

        int curr = solve(root);
        if( curr == 1 ) ans++;

        return ans;
    }
}
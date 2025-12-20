class Solution {
    static int solve(TreeNode curr){
        if(( curr.left == null && curr.right == null ) )return 0;

        int left = 0;
        if(curr.left != null) left = solve(curr.left);

        int right = 0;
        if(curr.right != null) right = solve(curr.right);

        if(curr.right == null){

            if(curr.left.val == 2){
                curr.val = 1;
                return left ;
            }
            else if(curr.left.val == 1){
                curr.val = 0;
                return left ;
            }
            else {
                curr.val = 2;
                return 1 + left ;
            }
        }
        else if(curr.left == null){

            if(curr.right.val == 2){
                curr.val = 1;
                return right ;
            }
            else if(curr.right.val == 1){
                curr.val = 0;
                return right ;
            }
            else {
                curr.val = 2;
                return 1 + right ;
            }
        }
        else{
            if(curr.left.val == 0 || curr.right.val == 0 ){
                curr.val = 2;
                return 1 + left + right;
            }
            else if(curr.left.val == 2 || curr.right.val == 2){
                curr.val = 1;
                return left + right;
            }
            else if(curr.left.val == 1 || curr.right.val == 1){
                curr.val = 0;
                return left + right;
            }
            else {
                curr.val = 1;
                return left + right;
            }
        }
    }

    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null)return 1;
        int ans =  solve( root );

        if( root.val == 0 ){
            if(root.left != null && root.left.val == 2){
                return ans;
            }
            if(root.right != null && root.right.val == 2){
                return ans;
            }
            

            boolean left = false;
            if(root.left != null && root.left.val == 1){
                left = true;
            }
            if( root.right == null && left )ans++;

            boolean right = false;
            if(root.right != null && root.right.val == 1){
                right = true;
            }
            if( root.left == null && right )ans++;

            if( left && right ) ans++ ;
        }
        return ans;
    }
}
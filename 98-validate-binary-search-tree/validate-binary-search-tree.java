class Solution {
    private boolean checkRight( TreeNode root , long min , long max ){
        if( root.val >= max || root.val <= min )return false;
        
        if( root.left != null && !checkLeft(root.left , min , Math.min(root.val , max) ) )return false;
        if( root.right != null && !checkRight(root.right , Math.max(root.val , min) ,  max ) )return false;

        return true;
    }

    private boolean checkLeft( TreeNode root , long min , long max ){
        if( root.val >= max || root.val <= min )return false;
        
        if( root.left != null && !checkLeft(root.left , min , Math.min(root.val , max) ) )return false;
        if( root.right != null && !checkRight(root.right , Math.max(root.val , min) ,  max ) )return false;

        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        if( root == null )return true;

        if( root.left != null && !checkLeft(root.left , Long.MIN_VALUE , root.val) )return false;
        if( root.right != null && !checkRight(root.right , root.val , Long.MAX_VALUE ) )return false;
        
        return true;
    }
}
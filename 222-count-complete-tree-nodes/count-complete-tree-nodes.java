class Solution {
    private int count( TreeNode root , int level , int index ){
        int right = 0;
        int left = 0;

        if( root.right != null ){
            right = (level == -1 ? 0 : (1 << level) ) + count( root.right , level + 1 , 2*index );
        }
        
        if( root.left != null ){
            left = (level == -1 ? 0 : (1 << level) ) + count( root.left , level + 1 , 2*index - 1 );
        }
        
        if(left == 0 && right == 0) return (level == -1 ? 0 : (1 << level) ) + index;
        return Math.max( left , right );
    }
    public int countNodes(TreeNode root) {
        int node = 0;
        int level = 0;
        int index = 1;

        if( root == null ) return 0; 
        return count( root , -1 , 1 );
    }
}
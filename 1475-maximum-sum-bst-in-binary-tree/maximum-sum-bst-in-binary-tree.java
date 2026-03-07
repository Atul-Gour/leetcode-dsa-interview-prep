class Solution {
    int ans = 0;

    static class node{
        int min, max , sum;

        node( int min , int max , int sum ){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    private node find( TreeNode root ){

        if( root == null )return new node( Integer.MAX_VALUE , Integer.MIN_VALUE , 0 );
        
        node left = find( root.left );
        node right = find( root.right );

        if( root.val <= left.max || root.val >= right.min ) return new node( Integer.MIN_VALUE , Integer.MAX_VALUE , 0 );
        int currSum = left.sum + right.sum + root.val;
        ans = Math.max( ans , currSum );
        return new node( Math.min( left.min , root.val ) , Math.max( right.max , root.val ) , currSum );
    }

    public int maxSumBST(TreeNode root) {
        find(root);
        return ans;
    }
}
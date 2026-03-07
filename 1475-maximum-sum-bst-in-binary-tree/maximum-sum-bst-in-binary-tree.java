class Solution {
    int ans = 0;

    static class node{
        int min, max , sum;
        boolean valid;

        node( int min , int max , int sum , boolean valid ){
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.valid = valid;
        }
    }

    private node find( TreeNode root ){
        
        node right = null , left = null;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int currMin = root.val;
        int currMax = root.val;
        int currSum = root.val;
        boolean canTake = true;

        if( root.left != null ){
            left = find( root.left );
            if( !left.valid )canTake = false;

            currSum += left.sum;
            currMin = left.min;
            min = left.max;
        }

        if( root.right != null ){
            right = find( root.right );
            if( !right.valid )canTake = false;

            currSum += right.sum;
            currMax = right.max;
            max = right.min;
        }
        if( root.val <= min || root.val >= max || !canTake  ) return new node(0 , 0 , 0 , false);
        ans = Math.max( ans , currSum );
        return new node( currMin , currMax , currSum , true );
    }

    public int maxSumBST(TreeNode root) {
        find(root);

        return ans;
    }
}
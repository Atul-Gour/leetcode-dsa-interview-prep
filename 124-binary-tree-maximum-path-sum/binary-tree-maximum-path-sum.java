/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;

    private int find( TreeNode root ){
        if( root == null )return -1001;

        int left = find( root.left );
        int right = find( root.right );

        if( left == -1001 && right == -1001 ){
            ans = Math.max( ans , root.val );
            return root.val;
        }

        long currMax = root.val;
        currMax = Math.max( currMax , root.val + left );
        currMax = Math.max( currMax , root.val + right );
        currMax = Math.max( currMax , Integer.MIN_VALUE );
        int returnMax = (int)currMax;

        currMax = Math.max( currMax , root.val + right + left );
        currMax = Math.max( currMax , Integer.MIN_VALUE );
        ans = (int) Math.max( ans , currMax );
        
        return returnMax;
    }

    public int maxPathSum(TreeNode root) {
        find( root );
        
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
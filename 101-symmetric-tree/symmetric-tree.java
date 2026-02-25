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
    private boolean isSame( TreeNode p , TreeNode q ){
        if( p == null || q == null ){
            if( p == null && q == null ) return true;
            else return false;
        }

        if (p.val != q.val)return false;

        if( !isSame( p.left , q.right ) )return false;
        if( !isSame( p.right , q.left ) )return false;

        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSame( root.left , root.right );
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q )return root;

        if( root.val > p.val && root.val < q.val )return root;
        else if( root.val < p.val ) return LCA( root.right , p , q );
        else return LCA( root.left , p , q );
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( p.val > q.val )return LCA( root , q , p );
        else return LCA( root , p , q );
    }
}
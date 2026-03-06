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
    private boolean present( TreeNode root , TreeNode curr , int k ){
        int a = curr.val;
        int target = k - a;

        if( a == target )return false;
        
        while( root != null ){
            if( root.val == target ) return true;
            else if( root.val < target ) root = root.right;
            else root = root.left;
        }

        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while( !q.isEmpty() ){
            TreeNode curr = q.poll();
            if( present( root , curr , k) )return true;
            if( curr.left != null )q.offer( curr.left );
            if( curr.right != null )q.offer( curr.right );
        }

        return false;
    }
}
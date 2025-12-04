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
    boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null ^ subRoot == null)return false;
        System.out.println("Hii");
        if(root == null) return true;
        System.out.println(root.val +" "+subRoot.val);
        if(root.val != subRoot.val)return false;
        return (isSame(root.left, subRoot.left) && isSame(root.right , subRoot.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root.val == subRoot.val) {
            if(isSame(root, subRoot))return true;
        }
        if(root.left!=null)if (isSubtree(root.left, subRoot)) return true;
        if(root.right!=null)if (isSubtree(root.right, subRoot)) return true;
        return false;
    }
}
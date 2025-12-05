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
    int index=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return -1;
        
        int value = kthSmallest(root.left,k);
        if(value!=-1)return value;

        if(index++ == k-1){
            return root.val;
        }

        value = kthSmallest(root.right,k);
        if(value!=-1)return value;

        return -1;
    }
}
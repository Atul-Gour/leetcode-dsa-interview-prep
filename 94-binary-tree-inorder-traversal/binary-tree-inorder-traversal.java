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
    public List<Integer> inorderTraversal(TreeNode head) {
        List<Integer> inorder = new ArrayList<>();

        while( head != null ){
            if( head.left == null ){
                inorder.add( head.val );
                head = head.right;
            }
            else{
                TreeNode temp = head.left;

                while( temp.right != null && temp.right != head ){
                    temp = temp.right;
                }

                if( temp.right == null ){
                    temp.right = head;
                    head = head.left;
                }
                else{
                    temp.right = null;
                    inorder.add( head.val );
                    head = head.right;
                }
            }
        }

        return inorder;
    }
}
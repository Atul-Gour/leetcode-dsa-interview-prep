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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        if( root == null )return list;


        while( !stack.isEmpty() ){
            TreeNode curr = stack.pop();

            if( curr.left != null )stack.push(curr.left);
            if( curr.right != null )stack.push(curr.right);
            
            list.add( curr.val );
        }

        Collections.reverse(list);
        return list;
    }
}
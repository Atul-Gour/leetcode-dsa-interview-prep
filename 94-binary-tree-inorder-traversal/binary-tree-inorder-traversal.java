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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if( root == null )return list;

        while( !stack.isEmpty() ){
            TreeNode curr = stack.peek();

            if( curr != null ){
                stack.push( curr.left );
            }else{
                stack.pop();
                if( stack.isEmpty() )return list;
                curr = stack.pop();
                list.add( curr.val );
                stack.push( curr.right );
            }
        }

        return list;
    }
}
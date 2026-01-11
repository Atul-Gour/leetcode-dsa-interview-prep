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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        return rightSideView(root, 0, list);
    }

    public List<Integer> rightSideView(TreeNode root, int depth, List<Integer> list) {
        if (root == null) {
            return list;
        }

          if (list.size() == depth) {
            
            list.add(root.val);
        }
        rightSideView(root.right, depth+1, list);
        rightSideView(root.left, depth+1, list);
      
         
        return list;
    }
}
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
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        q.add(root);
        int n = 0;
        TreeNode currNode;

        while(!q.isEmpty()){
            n = q.size();
            for(int i = 0 ; i < n - 1 ; i++ ){
                currNode = q.poll();
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            currNode = q.poll();
            ans.add(currNode.val);
            if(currNode.left != null) q.add(currNode.left);
            if(currNode.right != null) q.add(currNode.right);
        }
        return ans;
    }
}
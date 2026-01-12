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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        solve(root , new StringBuilder() , list);
        return list;
    }

    void solve( TreeNode curr , StringBuilder sb , List<String> list){

        if(curr.left == null && curr.right == null){
            int len = sb.length();
            sb.append(curr.val);
            list.add(new String(sb.toString()));
            sb.setLength(len);
            return;
        }
        
        sb.append(curr.val).append("->");
        int len ;
        
        if(curr.left != null) {
            len = sb.length();
            solve(curr.left , sb , list);
            sb.setLength(len);
        }

        if(curr.right != null) {
            len = sb.length();
            solve(curr.right , sb , list);
            sb.setLength(len);
        }
    }
}
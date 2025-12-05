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

    TreeNode find(TreeNode root, int p, int q){
        if(root == null)return null;
        int rootVal= root.val;
        if((p==rootVal || q==rootVal) ||(p<rootVal && q>rootVal))return root;
        else if(q<rootVal){
            return find(root.left ,p ,q);
        }else{
            return find(root.right ,p ,q);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val)return find(root, q.val , p.val);
        else return find(root, p.val , q.val);
    }
}
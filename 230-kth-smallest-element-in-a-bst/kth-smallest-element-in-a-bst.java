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
    int[] arr ;
    int index=0;
    boolean updated = false;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return -1;
        if(!updated){
            arr= new int[k];
            updated =true;
        }
        
        int value = kthSmallest(root.left,k);
        if(value!=-1)return value;

        arr[index]= root.val;
        if(index++ == k-1){
            Arrays.sort(arr);
            return arr[k-1];
        }

        value = kthSmallest(root.right,k);
        if(value!=-1)return value;

        return -1;
    }
}
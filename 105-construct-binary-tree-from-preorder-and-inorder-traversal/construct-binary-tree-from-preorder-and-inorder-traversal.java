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
    int preIndex = 0;
    HashMap<Integer , Integer> inIndex = new HashMap<>();

    private TreeNode build( int[] preorder , int inStart , int inEnd ){
        if( inStart > inEnd )return null;

        int val = preorder[preIndex++];
        TreeNode curr = new TreeNode( val );

        int currIndex = inIndex.get(val);
        curr.left = build( preorder , inStart , currIndex - 1 );
        curr.right = build( preorder , currIndex + 1 , inEnd );

        return curr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

       for( int i = 0 ; i < inorder.length ; i++ )inIndex.put(inorder[i] , i);
       
       return build( preorder , 0 , inorder.length - 1 );
    }


}
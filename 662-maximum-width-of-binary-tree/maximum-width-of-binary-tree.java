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

    static class MyNode{
        TreeNode node ;
        int x = 0;

        MyNode( TreeNode node , int x ){
            this.node = node;
            this.x = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if( root == null ) return 0;

        int maxWidth = 0;
        Queue<MyNode> q = new ArrayDeque<>();
        q.offer( new MyNode( root , 1 ) );

        while( !q.isEmpty() ){
            int size = q.size();
            int currWidth = 1;

            for( int i = 0 ; i < size ; i++ ){
                MyNode currNode = q.poll();
                
                if( i == 0 )currWidth -= currNode.x;
                if( i == size - 1 ) currWidth += currNode.x;

                if( currNode.node.left != null )q.offer( new MyNode( currNode.node.left , (currNode.x * 2) - 1 ) );
                if( currNode.node.right != null )q.offer( new MyNode( currNode.node.right , currNode.x * 2 ) );
            }

            maxWidth = Math.max( maxWidth , currWidth );

        }

        return maxWidth;
    }
}
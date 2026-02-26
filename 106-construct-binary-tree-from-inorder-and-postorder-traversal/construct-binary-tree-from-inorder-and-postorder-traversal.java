class Solution {
    int postIndex ;
    HashMap<Integer , Integer> inIndex = new HashMap<>();

    private TreeNode build( int[] postorder , int inStart , int inEnd ){
        if( inStart > inEnd )return null;

        int val = postorder[postIndex--];
        TreeNode curr = new TreeNode( val );

        int currIndex = inIndex.get(val);
        curr.right = build( postorder , currIndex + 1 , inEnd );
        curr.left = build( postorder , inStart , currIndex - 1 );

        return curr;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

       for( int i = 0 ; i < inorder.length ; i++ )inIndex.put(inorder[i] , i);
       postIndex = inorder.length - 1;
       return build( postorder , 0 , inorder.length - 1 );
    }


}
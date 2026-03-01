class Solution {
    int preIndex = 0;

    private TreeNode create( int[] preorder , int min , int max ){
        if( preIndex >= preorder.length )return null;

        int curr = preorder[preIndex];
        TreeNode root ;
        if( curr < max && curr > min ){
            root = new TreeNode(curr);
            preIndex++;
        }else return null;

        root.left = create( preorder , min , Math.min(max , curr) );
        root.right = create( preorder , Math.max(min , curr) , max );

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return create( preorder , Integer.MIN_VALUE , Integer.MAX_VALUE );
    }
}
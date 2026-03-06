class Solution {
     TreeNode first , middle , last , prev;

    private void swap( TreeNode a , TreeNode b ){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void Inorder( TreeNode root ){
        if( root == null ) return ;

        if(root.left != null)  Inorder( root.left );

        if( prev != null ){
            if( root.val <= prev.val ){
                if( first == null ){
                    first = prev;
                    middle = root;
                }else{
                    last = root;
                    return;
                }
            }
        }

        prev = root;

        if(root.right != null) Inorder( root.right );        
    }

    public void recoverTree(TreeNode root) {
        Inorder( root );
        if( last == null ) swap( first , middle );
        else swap( first , last );
    }
}
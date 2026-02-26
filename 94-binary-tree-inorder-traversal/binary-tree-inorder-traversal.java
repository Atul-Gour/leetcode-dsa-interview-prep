class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        
        while( root != null ){
            if( root.left == null ){
                inorder.add( root.val );
                root = root.right;
            }else{
                TreeNode temp = root.left;

                while( temp.right != null && temp.right != root ){
                    temp = temp.right;
                }

                if( temp.right == null ){
                    temp.right = root;
                    root = root.left;
                }else{
                    inorder.add(root.val);
                    temp.right = null;
                    root = root.right;
                }
            }
        }
        return inorder;
    }
}
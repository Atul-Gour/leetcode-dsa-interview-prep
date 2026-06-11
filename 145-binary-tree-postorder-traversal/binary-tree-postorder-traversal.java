class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        while( root != null ){
            if( root.right == null ){
                postorder.add( root.val );
                root = root.left;
            }
            else{

                TreeNode temp = root.right;
                
                while( temp.left != null && temp.left != root ){
                    temp = temp.left;
                }

                if( temp.left == null ){
                    temp.left = root;
                    postorder.add( root.val );
                    root = root.right;
                }
                else{
                    temp.left = null;
                    root = root.left;
                }
            }
        }

        Collections.reverse( postorder );
        return postorder;
    }
}
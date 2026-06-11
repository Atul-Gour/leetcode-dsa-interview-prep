class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        
        TreeNode head = root;

        while( head != null ){
            if( head.left == null ){
                preorder.add( head.val );
                head = head.right;
            }
            else{
                TreeNode temp = head.left;

                while( temp.right != null && temp.right != head ){
                    temp = temp.right;
                }

                if( temp.right == null ){
                    temp.right = head;
                    preorder.add( head.val );
                    head = head.left;
                }
                else{
                    temp.right = null;
                    head = head.right;
                }
            }
        }

        return preorder;
    }
}
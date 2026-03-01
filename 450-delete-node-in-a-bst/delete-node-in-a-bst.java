class Solution {
    TreeNode switchNode( TreeNode parent , TreeNode curr , TreeNode root ){

        TreeNode replacingNode = null;
        TreeNode replacingNodeParent = null;

        if( curr.left != null ){
            replacingNode = curr.left;

            if(parent != null){
                if( parent.val < curr.val )parent.right = replacingNode;
                else parent.left = replacingNode;
            }

            if( curr.right != null ){
                TreeNode temp = curr.right;
                while( temp.left != null ){
                    temp = temp.left;
                }
                temp.left = replacingNode.right;
                replacingNode.right = curr.right;
            }

        }else if( curr.right != null ){
            replacingNode = curr.right;

            if(parent != null){
                if( parent.val < curr.val )parent.right = replacingNode;
                else parent.left = replacingNode;
            }

            if( curr.left != null ){
                TreeNode temp = curr.left;
                while( temp.right != null ){
                    temp = temp.right;
                }
                temp.right = replacingNode.left;
                replacingNode.left = curr.left;
            }
        }else{
            if(parent != null){
                if( parent.val < curr.val )parent.right = null;
                else parent.left = null;
            }
        }

        if( parent == null )return replacingNode;
        else return root;

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode curr = root;

        while( curr != null ){
            if( curr.val == key )return switchNode( parent , curr , root );
            else if( curr.val < key ){
                parent = curr;
                curr = curr.right;
            }
            else {
                parent = curr;
                curr = curr.left;
            }
        }

        return root;
    }
}
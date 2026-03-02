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
class BSTIterator {
    TreeNode curr = null;


    public BSTIterator(TreeNode root) {
        this.curr = root;
    }
    
    public int next() {
        int nextNode = curr.val;

        while(curr != null){
            if( curr.left == null ){
                nextNode = curr.val;
                curr = curr.right;
                return nextNode;
            }else{
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }

                if( temp.right == null ){
                    temp.right = curr;
                    nextNode = curr.val;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    nextNode = curr.val;
                    curr = curr.right;
                    return nextNode;
                }
            }
        }

        

        return nextNode;
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
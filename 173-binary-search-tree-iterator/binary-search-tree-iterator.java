class BSTIterator {
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = root;
    }
    
    public int next() {
        while (curr != null) {

            if (curr.left == null) {
                int val = curr.val;
                curr = curr.right;
                return val;
            }

            TreeNode temp = curr.left;

            while (temp.right != null && temp.right != curr) {
                temp = temp.right;
            }

            if (temp.right == null) {
                temp.right = curr;   // create thread
                curr = curr.left;
            } else {
                temp.right = null;   // remove thread
                int val = curr.val;
                curr = curr.right;
                return val;
            }
        }

        return -1; // won't reach if hasNext() is used properly
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}
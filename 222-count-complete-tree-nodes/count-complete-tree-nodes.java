class Solution {

    static boolean found;
    static int ans;

    private int getLeftDepth(TreeNode root) {
        int d = 0;
        while (root != null) { root = root.left; d++; }
        return d;
    }

    private int count(TreeNode root, int index) {
        if (root == null) return 0;

        int leftDepth  = getLeftDepth(root.left);
        int rightDepth = getLeftDepth(root.right);

        if (leftDepth == rightDepth) {
            if (root.right == null) return index;  
            return count(root.right, 2 * index + 1);
        } else {
            return count(root.left, 2 * index);
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        found = false;
        ans = 0;
        int totalDepth = getLeftDepth(root) - 1;
        return count(root, 1);
    }
}
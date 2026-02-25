class Solution {

    int ans = Integer.MIN_VALUE;

    private int find(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));

        int currentPath = root.val + left + right;

        ans = Math.max(ans, currentPath);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        find(root);
        return ans;
    }
}
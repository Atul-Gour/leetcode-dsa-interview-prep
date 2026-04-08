class Solution {

    private int[] count(TreeNode root, int index) {
        if (root == null) return new int[]{0, 0};

        int[] left  = count(root.left,  2 * index);
        int[] right = count(root.right, 2 * index + 1);

        // leaf node
        if (left[0] == 0 && right[0] == 0) return new int[]{index, 1};

        // left deeper — last node is in left subtree
        if (left[1] > right[1]) return new int[]{left[0], left[1] + 1};

        // same depth or right deeper — last node is in right subtree
        return new int[]{right[0], right[1] + 1};
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return count(root, 1)[0];
    }
}
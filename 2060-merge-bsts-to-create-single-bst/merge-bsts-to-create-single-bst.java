class Solution {

    public TreeNode canMerge(List<TreeNode> trees) {

        Map<Integer, TreeNode> roots = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (TreeNode t : trees) {
            roots.put(t.val, t);
            count.put(t.val, count.getOrDefault(t.val, 0) + 1);

            if (t.left != null)
                count.put(t.left.val, count.getOrDefault(t.left.val, 0) + 1);

            if (t.right != null)
                count.put(t.right.val, count.getOrDefault(t.right.val, 0) + 1);
        }

        TreeNode root = null;

        for (TreeNode t : trees) {
            if (count.get(t.val) == 1) {
                root = t;
                break;
            }
        }

        if (root == null) return null;

        roots.remove(root.val);

        if (!build(root, Long.MIN_VALUE, Long.MAX_VALUE, roots))
            return null;

        if (!roots.isEmpty()) return null;

        return root;
    }

    private boolean build(TreeNode node, long min, long max, Map<Integer, TreeNode> roots) {

        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        if (node.left == null && node.right == null && roots.containsKey(node.val)) {

            TreeNode merge = roots.get(node.val);
            node.left = merge.left;
            node.right = merge.right;
            roots.remove(node.val);
        }

        return build(node.left, min, node.val, roots) &&
               build(node.right, node.val, max, roots);
    }
}
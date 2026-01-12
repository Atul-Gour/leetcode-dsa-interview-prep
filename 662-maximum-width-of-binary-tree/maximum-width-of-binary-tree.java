class Pair {
    TreeNode node;
    long index;   // use long to avoid overflow

    Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long idx = p.index;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (p.node.left != null)
                    q.offer(new Pair(p.node.left, 2 * idx));

                if (p.node.right != null)
                    q.offer(new Pair(p.node.right, 2 * idx + 1));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}

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
class MyNode {
    TreeNode node;
    int index;

    MyNode(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {

    int ans = 1;

    public int widthOfBinaryTree(TreeNode root) {
        Queue<MyNode> q = new LinkedList<>();
        if (root.left != null)
            q.offer(new MyNode(root.left, -1));
        if (root.right != null)
            q.offer(new MyNode(root.right, 1));

        while (!q.isEmpty()) {
            int n = q.size();

            int start = 0;
            int end = 0;

            for (int i = 0; i < n; i++) {

                MyNode myCurr = q.poll();

                TreeNode curr = myCurr.node;
                int ind = myCurr.index;

                if (i == 0)
                    start = ind;
                if (i == n - 1)
                    end = ind;

                if (ind < 0) {
                    if (curr.left != null)
                        q.offer(new MyNode(curr.left, 2 * ind));
                    if (curr.right != null)
                        q.offer(new MyNode(curr.right, (2 * ind) + 1));
                } else {
                    if (curr.left != null)
                        q.offer(new MyNode(curr.left, (2 * ind) - 1));
                    if (curr.right != null)
                        q.offer(new MyNode(curr.right, (2 * ind)));
                }
            }

            int len;

            if (end > 0 && start > 0)
                len = end - start + 1;
            else if (end < 0 && start < 0)
                len = Math.abs(start - end) + 1;
            else
                len = end - start;

            ans = Math.max(ans, len);

        }
        return ans;
    }
}
class Solution {

    private void buildParent(TreeNode root,
                             TreeNode parent,
                             HashMap<TreeNode, TreeNode> parentMap) {

        if (root == null) return;

        parentMap.put(root, parent);

        buildParent(root.left, root, parentMap);
        buildParent(root.right, root, parentMap);
    }

    public List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(root, null, parentMap);

        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty() && dist < k) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }

            dist++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}
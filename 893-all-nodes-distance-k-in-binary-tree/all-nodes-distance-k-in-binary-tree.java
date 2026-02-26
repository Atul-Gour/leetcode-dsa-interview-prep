class Solution {

    private void dfs(TreeNode root,
                     HashMap<TreeNode, List<TreeNode>> graph) {

        if (root == null) return;

        graph.putIfAbsent(root, new ArrayList<>());

        if (root.left != null) {
            graph.putIfAbsent(root.left, new ArrayList<>());
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
            dfs(root.left, graph);
        }

        if (root.right != null) {
            graph.putIfAbsent(root.right, new ArrayList<>());
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
            dfs(root.right, graph);
        }
    }

    public List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(root, graph);

        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty() && dist < k) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                for (TreeNode neigh : graph.get(curr)) {
                    if (!visited.contains(neigh)) {
                        visited.add(neigh);
                        q.offer(neigh);
                    }
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
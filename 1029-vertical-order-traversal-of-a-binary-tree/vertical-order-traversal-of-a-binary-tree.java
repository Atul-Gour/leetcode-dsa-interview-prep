class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{root, 0, 0});

        int minCol = 0, maxCol = 0;

        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            if (node == null) continue;

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            map.computeIfAbsent(col, k -> new ArrayList<>())
               .add(new int[]{row, node.val});

            q.add(new Object[]{node.left, row + 1, col - 1});
            q.add(new Object[]{node.right, row + 1, col + 1});
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int c = minCol; c <= maxCol; c++) {
            List<int[]> list = map.get(c);

            list.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] p : list) colList.add(p[1]);

            ans.add(colList);
        }

        return ans;
    }
}

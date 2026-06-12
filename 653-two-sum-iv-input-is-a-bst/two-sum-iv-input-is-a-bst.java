class Solution {

    private TreeNode getNext(TreeNode curr) {
        while (curr != null) {
            if (curr.left == null) {
                TreeNode res = curr;
                curr = curr.right;
                return res;
            }

            TreeNode pred = curr.left;

            while (pred.right != null && pred.right != curr) {
                pred = pred.right;
            }

            if (pred.right == null) {
                pred.right = curr;
                curr = curr.left;
            } else {
                pred.right = null;
                TreeNode res = curr;
                curr = curr.right;
                return res;
            }
        }

        return null;
    }

    private TreeNode getPrev(TreeNode curr) {
        while (curr != null) {
            if (curr.right == null) {
                TreeNode res = curr;
                curr = curr.left;
                return res;
            }

            TreeNode succ = curr.right;

            while (succ.left != null && succ.left != curr) {
                succ = succ.left;
            }

            if (succ.left == null) {
                succ.left = curr;
                curr = curr.right;
            } else {
                succ.left = null;
                TreeNode res = curr;
                curr = curr.left;
                return res;
            }
        }

        return null;
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        int i = 0;
        int j = inorder.size() - 1;

        while (i < j) {
            int sum = inorder.get(i) + inorder.get(j);

            if (sum == k) return true;
            if (sum < k) i++;
            else j--;
        }

        return false;
    }
}
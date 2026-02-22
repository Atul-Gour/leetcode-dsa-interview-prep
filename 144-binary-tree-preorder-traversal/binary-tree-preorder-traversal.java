
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while( !stack.isEmpty() ){
            TreeNode curr = stack.pop();
            if( curr == null )continue;
            list.add(curr.val);
            if( curr.right != null )stack.push(curr.right);
            if( curr.left != null )stack.push(curr.left);
        }

        return list;
    }
}
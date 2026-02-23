class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push( root );

        while( !stack.isEmpty() ){
            TreeNode curr = stack.pop();
            if( curr == null) continue;

            list.add( curr.val );
            stack.push(curr.left);
            stack.push(curr.right);
        }

        Collections.reverse( list );

        return list;
    }
}
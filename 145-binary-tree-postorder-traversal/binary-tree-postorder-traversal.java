class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while( !stack.isEmpty() || curr!= null ){
            if( curr != null){
                stack.push( curr );
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;

                if( temp != null){
                    curr = temp;
                }else{
                    temp = stack.pop();
                    list.add(temp.val);

                    while( !stack.isEmpty() && temp == stack.peek().right ){
                        temp = stack.pop();
                        list.add( temp.val );
                    }
                }
            }
        }

        return list;
    }
}
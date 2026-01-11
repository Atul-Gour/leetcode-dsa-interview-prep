class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean straight = true;
        int n = 1;

        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();

            n = q.size();
            for(int i = 0 ; i < n ; i++){
                TreeNode currNode = q.poll();
                list.add(currNode.val);
                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }

            if(straight){
                ans.add(list);
                straight = false;
            }else{
                Collections.reverse(list);
                ans.add(list);
                straight = true;
            }
        }
        return ans;
    }
}
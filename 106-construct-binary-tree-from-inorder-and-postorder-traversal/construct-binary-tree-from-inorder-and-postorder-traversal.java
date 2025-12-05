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
class Solution {

    TreeNode make(HashMap<Integer, Integer> map, int[] inorder, Stack<Integer> st, int left, int right){
        
        if(st.isEmpty() || left > right || right> inorder.length || left < 0)return null;

        int parentIndex =map.get(st.peek());
        TreeNode curr = new TreeNode(st.pop());
        if(st.isEmpty() || left==right)return curr;
        
        int childIndex = map.get(st.peek());

        if(childIndex>parentIndex && childIndex<=right)
        curr.right= make(map, inorder, st, parentIndex+1 , right);

        if(st.isEmpty() || left==right)return curr;
        childIndex = map.get(st.peek());

        if(childIndex<parentIndex && childIndex>=left){
            curr.left= make(map, inorder, st, left , parentIndex-1);
        }
        return curr;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        Boolean [] visited = new Boolean[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n; i++){
            map.put(inorder[i],i);
        }
        for(int i: postorder){
            st.push(i);
        }
        TreeNode root = make(map, inorder, st,0 ,n-1);
        return root;

    }
}
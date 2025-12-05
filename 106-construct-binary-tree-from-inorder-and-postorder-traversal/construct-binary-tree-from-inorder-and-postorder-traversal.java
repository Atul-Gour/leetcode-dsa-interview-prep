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

int postIndex;

public TreeNode build(HashMap<Integer,Integer> map,int start,int end, int[] postorder){
if(start > end) return null;
int rootNode= postorder[postIndex--];
TreeNode root=new TreeNode(rootNode);

int index=map.get(rootNode);
root.right=build(map,index+1,end,postorder);
root.left=build(map,start,index-1,postorder);

return root;
}


    public TreeNode buildTree(int[] inorder, int[] postorder){
             postIndex= postorder.length-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(map,0,inorder.length-1,postorder);
        
        
    }
}
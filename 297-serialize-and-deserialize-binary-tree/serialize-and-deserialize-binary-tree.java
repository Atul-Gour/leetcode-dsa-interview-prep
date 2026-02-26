/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if( root == null )return "#N";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while( !q.isEmpty() ){
            TreeNode curr = q.poll();
            if(curr.val == 1001){
                sb.append("#N");
                continue;
            }

            sb.append("#" + curr.val);

            if( curr.left == null ) q.offer(new TreeNode(1001));
            else q.offer(curr.left);

            if( curr.right == null )q.offer(new TreeNode(1001));
            else q.offer(curr.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("#");
        if( nodes[1].equals("N") )return null;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode( Integer.parseInt(nodes[1]) );
        q.offer(root);
        int index = 2;

        while( !q.isEmpty() ){
            TreeNode curr = q.poll();

            String left = nodes[index++];
            if( !left.equals("N") ){
                curr.left = new TreeNode( Integer.parseInt(left) );
                q.offer(curr.left);
            }

            String right = nodes[index++];
            if( !right.equals("N") ){
                curr.right = new TreeNode( Integer.parseInt(right) );
                q.offer(curr.right);
            }

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
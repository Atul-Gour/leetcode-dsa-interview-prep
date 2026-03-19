public class Codec {

    public String serialize(TreeNode root) {
        if( root == null )return "#N";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while( !q.isEmpty() ){
            TreeNode curr = q.poll();
            if( curr == null ){
                sb.append("#N");
                continue;
            }

            sb.append("#" + curr.val);
            q.offer(curr.left);
            q.offer(curr.right);

        }
        
        return sb.toString();
    }

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
class Solution {

    private boolean create( TreeNode node , int min , int max , HashMap<Integer , TreeNode> roots ){

        if( node.val <= min || node.val >= max )return false;

        if( node.left != null ){
            if(roots.containsKey( node.left.val ) ){
                node.left = roots.get(node.left.val);
                roots.remove( node.left.val );
                if( !create( node.left , min , Math.min( max , node.val ) , roots ))return false;
            }
            else{
                if( node.left.val <= min || node.left.val >= Math.min( max , node.val ) )return false;
            }
        }

        if( node.right != null ){
            if(roots.containsKey( node.right.val ) ){
                node.right = roots.get(node.right.val);
                roots.remove( node.right.val );
                if( !create( node.right , Math.max( min , node.val ) , max , roots ) )return false;
            }
            else{
                if( node.right.val <= Math.max( min , node.val ) || node.right.val >= max )return false;
            }
        }

        return true;

    }

    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer , TreeNode> roots = new HashMap<>();
        HashMap< Integer , Integer > nodeFreq  = new HashMap<>();

        for( TreeNode tree : trees ){
            roots.put( tree.val , tree );
            nodeFreq.put( tree.val , nodeFreq.getOrDefault( tree.val , 0 ) + 1 );
            if( tree.left != null ) nodeFreq.put( tree.left.val , nodeFreq.getOrDefault( tree.left.val , 0 ) + 1 );
            if( tree.right != null ) nodeFreq.put( tree.right.val , nodeFreq.getOrDefault( tree.right.val , 0 ) + 1 );
        }

        TreeNode root = null;

        for( Map.Entry< Integer , Integer > entry : nodeFreq.entrySet() ){
            if( entry.getValue() == 1 && roots.containsKey( entry.getKey() ) ){
                root = roots.get( entry.getKey() );
                break;
            }
        }

        if(root == null)return root;
        roots.remove( root.val );
        if( !create( root , Integer.MIN_VALUE , Integer.MAX_VALUE , roots ) ) return null;

        if( roots.size() == 0 )return root;
        else return null;
    }

}
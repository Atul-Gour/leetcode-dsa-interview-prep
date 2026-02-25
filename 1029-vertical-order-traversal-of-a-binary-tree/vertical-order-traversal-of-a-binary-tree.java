class Solution {

    private void find( TreeNode curr  , int x , int y , TreeMap<Integer , ArrayList< int[] > > plane ){
        if( curr == null )return;

        plane.computeIfAbsent( x , f -> new ArrayList<>() ).add( new int[]{ y , curr.val } );

        find( curr.left , x - 1 , y + 1 , plane );
        find( curr.right , x + 1 , y + 1 , plane );
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer , ArrayList< int[] > > plane = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        find( root , 0 , 0 , plane );

        for( int x : plane.keySet() ){
            ArrayList<int[]> vertices = plane.get(x);
            List<Integer> column = new ArrayList<>();

            Collections.sort( vertices , (a ,b) -> {
                if( a[0] != b[0] ){
                    return Integer.compare( a[0] , b[0] );
                }else{
                    return Integer.compare( a[1] , b[1] );
                }
            } );

            for( int[] vertex : vertices ){
                column.add( vertex[1] );
            }

            ans.add(column);
        }

        return ans;
    }
}
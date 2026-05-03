class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add( new ArrayList<>( List.of( 1 ) ) );

        for( int step = 1 ; step < numRows ; step++ ){

            List<Integer> currList = new ArrayList<>();
            List<Integer> prevList = ans.get( ans.size() - 1 );

            currList.add(1);

            for( int i = 0 ; i < prevList.size() - 1 ; i++ ){
                currList.add( prevList.get( i ) + prevList.get( i + 1 ) );
            }

            currList.add(1);

            ans.add( currList );
        }

        return ans;
    }
}
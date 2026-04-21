class Solution {

    boolean solve( int index , int jump , int lastIdx , int[] stones , HashMap<Long , Boolean> map ){
        int n = stones.length;
        if( index == n-1 ) return jump == stones[n-1] - stones[lastIdx] ? true : false;
        if( jump < stones[index] - stones[lastIdx] ) return false;

        long key = (long)index << 47 | lastIdx << 15 | jump;
        if( map.containsKey( key ) ) return map.get(key);

        boolean ans = false;
        
        if( jump > stones[index] - stones[lastIdx] ){
            ans = solve( index + 1 , jump , lastIdx , stones , map );
        }
        else{
            ans = solve( index + 1 , jump - 1 , index ,  stones , map ) ||
                  solve( index + 1 , jump , index ,  stones , map ) ||
                  solve( index + 1 , jump + 1 , index , stones , map );
        }

        map.put( key , ans );
        return ans;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Long , Boolean> map = new HashMap<>();

        return solve( 1 , 1 , 0 , stones , map );

    }
}
class Solution {

    boolean solve( int index , int jumps, int[] stones , HashSet<Long> set ){
        int n = stones.length;
        if( index == n-1 ) return true;
        if( index >= n ) return false;

        for( int i = index + 1 ; i < n ; i++ ){
            int jumpNeeded = stones[i] - stones[index];

            if( jumpNeeded == jumps || jumpNeeded == jumps - 1 || jumpNeeded == jumps + 1 ){
                long key = (long)i << 32 | jumpNeeded;
                if( set.contains(key) ) continue;
                if( solve( i , jumpNeeded , stones , set ) ) return true;
                set.add(key);
            }
            if( jumpNeeded > jumps ) return false;
        }

        return false;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashSet<Long> set = new HashSet<>();

        return solve( 0 , 0 , stones , set );

    }
}
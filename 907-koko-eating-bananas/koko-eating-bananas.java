class Solution {
    private boolean possible( int[] piles , int k , int h ){
        int time = 0;

        for( int pile : piles ){
            if( pile % k == 0 ) time += pile/k;
            else time += pile/k + 1;
        }

        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        
        for( int pile : piles ) r = Math.max( pile , r );

        while( l < r ){
            int mid = l + ( r - l )/2;
            if( possible( piles , mid , h ) ) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
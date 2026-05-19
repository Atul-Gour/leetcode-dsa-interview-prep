class Solution {
    
    private boolean possible( int[] arr , int k , int divisor ){
        int sum = 0;
        
        for( int ele : arr ){
            sum += ( ele + divisor - 1 )/divisor;
        }
        
        return sum <= k;
    }
    
    int smallestDivisor(int[] arr, int k) {
        int l = 1;
        int r = 0;
        
        for( int ele : arr ) r = Math.max( r , ele );
        
        while( l < r ){
            int mid = l + ( r - l )/2;
            
            if( possible( arr , k , mid ) ) r = mid;
            else l = mid + 1;
        }
        
        return l;
    }
}
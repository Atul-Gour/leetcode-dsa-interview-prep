class Solution {
    public int[] twoSum(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
                
        for( int r = 0 ; r < n ; r++ ){
            
            if( map.containsKey( k - arr[r] ) ){
                return new int[]{ map.get( k - arr[r] ) , r };
            }
            
            map.putIfAbsent( arr[r] , r );
        }
        
        return new int[]{};
    }
}
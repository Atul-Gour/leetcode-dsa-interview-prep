class Solution {
    boolean possible(int[] stones, int jump) {
        int n = stones.length;

        for (int i = 2; i < n; i++) {
            if (stones[i] - stones[i - 2] > jump) {
                return false;
            }
        }

        return true;
    }

    public int maxJump(int[] stones) {
        int n = stones.length;
        if( n == 2 ) return stones[1];
        
        int ans = stones[n-1];
        int low = 0;
        int high = stones[n-1];

        while( low <= high ){
            
            int mid = low + (( high - low ) / 2);
            
            
            if( possible(stones , mid ) ){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
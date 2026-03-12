class Solution {
    private boolean possible( int[] stones , int jump ){
        int n = stones.length;
        boolean[] taken = new boolean[n];
        int i = 0;
        // System.out.println(jump);

        while( i < n-1 ){
            int j = i + 1;
            if( (stones[j] - stones[i]) > jump ) return false;
            while( j + 1 < n && (stones[j + 1] - stones[i]) <= jump ){
                j++;
            }

            // System.out.println(i +" "+ j);
            taken[j] = true;
            i = j;
        }

        if(!taken[n-1])return false;

        taken[n-1] = taken[0] = false;
        i = n - 1;

        while( i > 0 ){
            int j = i - 1;
            while( j >= 0 && taken[j] ){
                j--;
            }
            if( taken[j] || (stones[i] - stones[j]) > jump ) return false;
            taken[j] = true;
            i = j;
        }

        if(!taken[0])return false;
        return true;
    }
    public int maxJump(int[] stones) {
        int n = stones.length;
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
class Solution {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] prefixGcd = new long[n];

        long ans = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd( max , nums[i] );
        }

        Arrays.sort( prefixGcd );

        int l = 0;
        int r = n-1;

        while( r > l ){
            ans += gcd( prefixGcd[r] , prefixGcd[l] );
            l++;
            r--;
        }

        return ans;
    }
}
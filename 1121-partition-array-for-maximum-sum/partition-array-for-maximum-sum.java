class Solution {

    private int solve( int index , int[] arr , int[] memo , int k){
        int n = arr.length;
        if(index >= n)return 0;

        if(memo[index] != -1)return memo[index];
        int ans = 0;
        int max = 0;

        for( int i = index ; i < n && i < index + k ; i++ ){
            max = Math.max( max , arr[i] );
            ans = Math.max( ans , max * ( i - index + 1 ) + solve( i + 1 , arr , memo , k ) );
        }

        return memo[index] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill( memo , -1 );
        
        return solve( 0 , arr , memo , k );

    }
}
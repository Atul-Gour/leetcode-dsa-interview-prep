class Solution {

    private boolean isPredecessor( String a , String b ){
        int n = a.length();
        int m = b.length();

        if( n + 1 != m ) return false;
        int i = 0 , j = 0;

        while( i < n && j < m ){

            if( a.charAt(i) == b.charAt(j) ){
                i++; j++;
            }else {
                j++;
            }

        }

        return (i == n) ;
    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int dp[] = new int[n];

        Arrays.fill( dp , 1 );
        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < i ; j++ ){

                if( isPredecessor( words[j] , words[i] ) ){
                    dp[i] = Math.max( dp[i] , 1 + dp[j]);
                }

            }
        }

        for( int ele : dp ) ans = Math.max( ans , ele );

        return ans;

    }
}
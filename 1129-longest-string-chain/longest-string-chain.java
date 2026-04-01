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
        int dp[][] = new int[n + 1][n + 1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = i ; j >= 0 ; j-- ){
                
                int skip = dp[i + 1][j];
                int take = 0;

                if( j == 0 || isPredecessor( words[j - 1] , words[i] ) ){
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][j] = Math.max( take , skip );
            }
        }

        return dp[0][0];

    }
}
class Solution {
    
    private String reducedString( String s ){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(  i < n ){

            if( s.charAt(i) == '*' ){
                sb.append('*');

                while( i < n && s.charAt(i) == '*' )i++;
            }

            if( i < n ) sb.append( s.charAt(i) );
            i++;
        }

        return sb.toString();
    } 

    public boolean isMatch(String s, String pp) {
        
        String p = reducedString(pp);

        int n = s.length();
        int m = p.length();

        int dp[][] = new int[n + 1][m + 1];

        dp[n][m] = 2;
        for( int i = 0 ; i < n ; i++ ) dp[i][m] = 1;
        for (int j = m - 1; j >= 0; j--) {
            if (p.charAt(j) == '*')
                dp[n][j] = dp[n][j + 1];
            else
                dp[n][j] = 1;
        }


        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = m-1 ; j >= 0 ; j-- ){

                if( p.charAt(j) == '?' ) dp[i][j] = dp[i+1][j+1]; 
                else if( p.charAt(j) == '*' ) dp[i][j] = (dp[i+1][j] == 2 || dp[i][j+1] == 2) ? 2 : 1;
                else if( s.charAt(i) == p.charAt(j) ) dp[i][j] = dp[i+1][j+1];
                
                if( dp[i][j] == 0 ) dp[i][j] = 1; 
            }
        }
        int j = 0;

        return dp[0][0] == 2;
    }
}
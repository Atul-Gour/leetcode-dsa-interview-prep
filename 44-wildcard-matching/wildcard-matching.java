class Solution {
    private int solve( int i , int j , String s , String p , int[][] dp ){

        int n = s.length();
        int m = p.length();

        // System.out.println( i + " " + j );

        if( dp[i][j] != 0 ) return dp[i][j];

        if( i == n && j == m ) return dp[i][j] = 2;
        if( j == m ) return dp[i][j] = 1;
        if( i == n ){
            for( int k = j ; k < m ; k++ ){
                if( p.charAt(k) != '*' ) return dp[i][j] = 1;
            }

            return dp[i][j] = 2;
        }
        

        if( p.charAt(j) == '?' ) return dp[i][j] = solve( i + 1 , j + 1 , s , p , dp ); 
        else if( p.charAt(j) == '*' ){
            for( int k = i ; k <= n ; k++ ){
                if( solve( k , j + 1 , s , p , dp ) == 2 ) return dp[i][j] = 2;
            }
        }
        else if( s.charAt(i) == p.charAt(j) ) return dp[i][j] = solve( i + 1 , j + 1 , s , p , dp );

        return dp[i][j] = 1;

    }
    
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

        return solve( 0 , 0 , s , p , dp ) == 2;
    }
}
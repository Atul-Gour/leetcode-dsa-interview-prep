class Solution {

    static String smallest ;

    private String optionA( String s , int a ){

        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < s.length() ; i++ ){
            if( i % 2 == 0 ) sb.append( s.charAt(i) );
            else{
                char ch = s.charAt(i);
                sb.append( (char)(((ch - '0' + a) % 10) + '0') );
            }
        }

        return sb.toString();
        
    }

    private String optionB( String s , int b ){

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for( int i = b ; i < n ; i++ ){
            sb.append( s.charAt(i) );
        }
        for( int i = 0 ; i < b && i < n ; i++ ){
            sb.append( s.charAt(i) );
        }

        return sb.toString();
    }

    private boolean compare(String a, String b) {
        int n = Math.min(a.length(), b.length());

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) < b.charAt(i);
            }
        }

        return a.length() < b.length();
    }

    private void solve( String s , int a , int b , HashSet<String> set  ){

        if( compare( s , smallest ) ) smallest = s;
        set.add(s);

        String stringA = optionA( s , a );
        String stringB = optionB( s , b );

        if( !set.contains( stringA ) ) solve( stringA , a , b , set );
        if( !set.contains( stringB ) ) solve( stringB , a , b , set );

    }

    public String findLexSmallestString(String s, int a, int b) {
        
        this.smallest = s;
        solve( s , a , b , new HashSet<>() );

        return smallest;

    }
}
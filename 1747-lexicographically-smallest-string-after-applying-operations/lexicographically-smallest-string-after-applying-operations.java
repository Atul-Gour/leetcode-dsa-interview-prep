class Solution {
    String smallest ;
    private String optionA(String sb, int a) {
        StringBuilder newSb = new StringBuilder(sb);

        for (int i = 1; i < sb.length(); i += 2) {
            int digit = (newSb.charAt(i) - '0' + a) % 10;
            newSb.setCharAt(i, (char)(digit + '0'));
        }

        return newSb.toString();
    }
    private String optionB( String sb , int b ){
        int n = sb.length();
        StringBuilder newSb = new StringBuilder();

        for( int i = n - b ; i < n ; i++ ) newSb.append( sb.charAt(i) );
        for( int i = 0 ; i < n - b ; i++ ) newSb.append( sb.charAt(i) );

        return newSb.toString();
    }
    private boolean compare(String a, String b) {
        int n = a.length();
        int m = b.length();
        int len = Math.min(n, m);

        for (int i = 0; i < len; i++) {
            if (a.charAt(i) < b.charAt(i)) return true;
            if (a.charAt(i) > b.charAt(i)) return false;
        }

        return n < m;
    }
    private void solve( String s , int a , int b , HashSet<String> set ){

        if( set.contains(s) )return;
        set.add( s );

        String temp = optionA( s , a );
        if( compare( temp , smallest ) ){
            smallest = temp;}
            solve( temp , a , b , set );
        

        temp = optionB( s , b );
        if( compare( temp , smallest ) ){
            smallest = temp;}
            solve( temp , a , b , set );
        

    }
    public String findLexSmallestString(String s, int a, int b) {
        smallest = s;
        solve( s , a , b % s.length()  , new HashSet<>() );
        return smallest;
    }
}
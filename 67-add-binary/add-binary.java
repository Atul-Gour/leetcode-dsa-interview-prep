class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while( i >= 0 || j >= 0  ){
            int aBit = 0;
            if( i >= 0 ) aBit = a.charAt( i ) - '0';
            int bBit = 0;
            if( j >= 0 ) bBit = b.charAt( j ) - '0';

            aBit += (bBit + carry) ;
            if( aBit == 0 ){
                sb.append('0');
            }
            else if( aBit == 1 ){
                sb.append( '1' );
                carry = 0;
            }
            else if( aBit == 2 ){
                sb.append('0');
                carry = 1;

            }
            else if( aBit == 3 ){
                sb.append( '1' );
                carry = 1;
            }

            i--;
            j--;
        }
        if( carry == 1 )sb.append( '1' );
        if( sb.isEmpty() )sb.append( '0' );


        return sb.reverse().toString();
    }
}
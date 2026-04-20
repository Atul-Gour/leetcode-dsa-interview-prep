class Solution {
    public int myAtoi(String s1) {
        String s = s1.trim();

        boolean positive = true;
        if( s.isEmpty() ) return 0;
        char ch = s.charAt(0);

        if( ch == '-' || ch == '+' ){
            positive = ch == '-' ? false : true;
            s = s.substring(1 , s.length());
        }
        else if( Character.isLetter(ch) ) return 0;
        
        long ans = 0;

        for( int i = 0 ; i < s.length() ; i++ ){
            
            ch = s.charAt(i);
            System.out.println( ans );

            if( Character.isDigit(ch)  ){
                ans = ans*10 + (ch - '0');
                
                if( !positive && -ans <= Integer.MIN_VALUE ) return Integer.MIN_VALUE;
                if( positive && ans >= Integer.MAX_VALUE ) return Integer.MAX_VALUE;

            }else break;

        }

        if( !positive ) ans *= -1;

        return (int)ans;
    }
}
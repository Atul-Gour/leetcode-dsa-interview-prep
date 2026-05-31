class Solution {

    private int put( char[] chars , int index , int count ){
        int digits = (int) Math.floor(Math.log10(count)) + 1;

        long divisor = (long) Math.pow( 10 , digits - 1 );

        for( int i = 0; i < digits ; i++ ){
            chars[index] = (char)((int)(count / divisor) + '0');
            count %= divisor;
            divisor /= 10;
            index++;
        }

        return index;
    }

    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;

        while( i < n ){
            char ch = chars[i];
            int count = 1;

            while( i + 1 < n && chars[i + 1] == ch ){
                i++;
                count++;
            }

            chars[j] = ch;
            j++;

            if( count > 1 ){
                j = put( chars , j , count );
            }

            i++;
        }

        return j;
    }
}
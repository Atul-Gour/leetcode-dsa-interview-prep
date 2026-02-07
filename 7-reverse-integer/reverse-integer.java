class Solution {
    public int reverse(int x) {
        if( x < 10 && x > -10) return x;

        int parity = 1;
        

        if( x < 0 ){
            parity *= -1;
            x = -x;
        }

        int digits = 0;

        int temp = x ;

        while( temp > 0 ){
            temp /= 10;
            digits++;
        }

        int trueDigits = 0;
        int digi = digits;

        digi--;
        temp = x ;

        while(temp > 0){
            temp %= ( Math.pow( 10 , digi-- ) );
            trueDigits++;
        }

        digits -= trueDigits;

        for( int i = 0 ; i < digits ; i++){
            x /= 10;
        }


        int ans = 0;
        int place = (int) Math.pow( 10 , trueDigits - 1 );

        if( trueDigits == 10 ){
            if( x % 10 > 2 )return 0; 
            temp = x / 10;
                       
            int max = 746384741;
            
            for( int i = 0 ; i < 9 ; i++ ){
                // if( i == 8 ){
                //     if( parity == -1 ){
                //         if( temp % 10 > 8 )return 0;

                //     }
                // }
                if( temp % 10 > max % 10 ){
                    return 0;
                }
                if( temp % 10 < max % 10 ){
                    break;
                }

                temp /= 10;
                max /= 10;
            }
        }

        while( x > 0 ){
            int digit = x % 10;
            x /= 10;
            ans += ( digit * place );
            place /= 10;
        }





        return ans * parity;

    }
}
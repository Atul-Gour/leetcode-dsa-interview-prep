class Solution {
    public int divide(int divid, int divis) {
        long dividend = divid;
        long divisor = divis;

        if( dividend < 0 && divisor < 0 ){
            dividend *= -1;
            divisor *= -1;
        }

        int isNegative = 1;

        if( dividend < 0 || divisor < 0 ){
            isNegative *= -1;

            if( dividend < 0 ) dividend *= -1;
            if( divisor < 0 ) divisor *= -1;
        }

        if(divisor > dividend)return 0;
        if( dividend == divisor ) return 1 * isNegative;
        if( divisor == 1 ){
            if( isNegative == 1 ){
                if( dividend >= 2_147_483_647L ) return 2147483647 * isNegative;
            }
            else if( isNegative == -1 ){
                if( dividend > 2_147_483_647L ) return (int)(2_147_483_648L * isNegative);
            }
            else return (int)dividend * isNegative;
        }

        long ans = 0;

        while( dividend >= divisor ){
            ans++;
            dividend -= divisor;
        }

        if( ans >= 2_147_483_648L ) ans = 2147483647;
        return (int) ans * isNegative;
    }
}
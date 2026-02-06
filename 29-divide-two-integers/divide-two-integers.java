class Solution {
    public int divide(int dividend, int divisor) {
        long ans = (long)dividend / divisor;
        if( ans >= 2_147_483_648L ) ans = 2147483647;
        return (int) ans;
    }
}
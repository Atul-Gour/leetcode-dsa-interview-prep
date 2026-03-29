class Solution {
    private int solve( int index , int buyIndex , int[] prices , Map<Long, Integer> map ){
        int n = prices.length;

        if( index >= n )return 0;

        long key = (long)index << 32 | buyIndex ; 
        if( map.containsKey(key) )return map.get(key);

        int sell = 0;
        if( buyIndex != -1 && prices[index] > prices[buyIndex] )
                 sell = solve( index + 1 , index + 1 , prices , map ) + prices[index] - prices[buyIndex];

        if( prices[index] < prices[buyIndex] ) buyIndex = index;
        int notSell = solve( index + 1 , buyIndex , prices , map );

        map.put( key , Math.max( sell , notSell ) );
        return map.get(key);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        Map<Long, Integer> map = new HashMap<>();

        return solve( 0 , 0 , prices , map );
    }
}
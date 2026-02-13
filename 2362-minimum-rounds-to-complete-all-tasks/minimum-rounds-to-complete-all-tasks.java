class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer , Integer> map = new HashMap<>();

        for( int task : tasks ){
            map.put( task , map.getOrDefault( task , 0 ) + 1 );
        }

        int ans = 0;

        for( int t : map.keySet() ){
            int task = map.get(t);

            if( task == 1 )return -1;
            
            ans += (task + 2)/3;
        }

        return ans;
    }
}
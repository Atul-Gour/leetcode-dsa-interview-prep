class Solution {

    private int dfs( String word , HashSet<String> set , HashMap<String , Integer> map ){

        if( map.containsKey( word ) ) return map.get( word );
        set.remove( word );

        int ans = 0;
        for( int i = 0 ; i <= word.length() ; i++ ){
            for( char ch = 'a' ; ch <= 'z' ; ch++ ){

                String newString = word.substring(0 , i) + ch + word.substring(i);

                if( set.contains( newString ) ){
                    ans = Math.max( ans , 1 + dfs( newString , set , map ) );
                }

            }
        }

        set.add(word);
        map.put( word , ans );
        return ans;
    }
    public int longestStrChain(String[] words) {
        HashSet<String> set = new HashSet<>();
        HashMap<String , Integer> map = new HashMap<>();

        for( String word : words ) set.add( word );
        int ans = 0;

        for( String word : words ){
            ans = Math.max( ans , 1 + dfs( word , set , map ) );
        }

        return ans;

    }
}
class Solution {

    private void dfs( String currWord , String endWord , List<String> currList , List<List<String>> ans , HashMap<String , HashSet<String> > map ){

        currList.add(currWord);

        if( currWord.equals( endWord ) ){
            List<String> reversed = new ArrayList<>(currList);
            Collections.reverse(reversed);
            ans.add( reversed );
            currList.remove(currList.size() - 1);
            return;
        } 

        for( String neigh : map.get( currWord ) ){
            dfs( neigh , endWord , currList , ans , map );
        }

        currList.remove(currList.size() - 1);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        if( !set.contains(endWord) ) return ans;

        HashMap<String , HashSet<String> > map = new HashMap<>();
        ArrayDeque<String> q = new ArrayDeque<>();

        for( String word : wordList ) map.put( word , new HashSet<>() );
        map.put( beginWord , new HashSet<>() );

        q.offer( beginWord );

        while( !q.isEmpty() ){
            int size = q.size();
            boolean found = false;
            ArrayList<String> toDelete = new ArrayList<>();
            HashSet<String> usedOnLevel = new HashSet<>();

            while( size-- > 0 ){
                String originalWord = q.poll();
                char characters[] = originalWord.toCharArray();

                for( int  i = 0 ; i < characters.length ; i++ ){

                    for( char ch = 'a' ; ch <= 'z' ; ch++ ){
                        if( ch == characters[i] ) continue;

                        characters[i] = ch;
                        String newWord = new String(characters);

                        if( set.contains(newWord) ){
                            if (!usedOnLevel.contains(newWord)) {
                                usedOnLevel.add(newWord);
                                q.offer(newWord);
                            }
                            map.get( newWord ).add( originalWord );
                            if( newWord.equals( endWord ) ) found = true;
                        }                         
                    }

                    characters[i] = originalWord.charAt(i);
                }
                
            }
            
            set.removeAll(usedOnLevel);
            for( String word : toDelete ) set.remove( word );
            if( found ) break;
        }

        dfs( endWord , beginWord , new ArrayList<>() , ans , map );

        return ans;
    }
}
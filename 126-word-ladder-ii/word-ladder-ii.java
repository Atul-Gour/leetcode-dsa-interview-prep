class Solution {

    private void dfs( String currWord , String endWord , HashMap<String , HashSet<String>> parent , List<String> currList , List<List<String>> ans ){

        currList.add( new String(currWord) );

        if( currWord.equals( endWord ) ){
            ArrayList<String> currAnsList = new ArrayList<>( currList );
            Collections.reverse( currAnsList );
            ans.add( currAnsList );
            currList.remove( currList.size() - 1 );
            return;
        }

        for( String neigh : parent.get(currWord) ){
            dfs( neigh , endWord , parent , currList , ans );
        }

        currList.remove( currList.size() - 1 );

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for( String word : wordList ) set.add(word);
        set.add( beginWord );

        if( !set.contains(endWord) ) return ans;

        HashMap<String , HashSet<String>> parent = new HashMap<>();
        HashMap<String , Integer> stepToReach = new HashMap<>();

        for( String word : set ) parent.put( word , new HashSet<>() );
        set.remove( beginWord );

        ArrayDeque< String > q = new ArrayDeque<>();
        q.offer( beginWord );

        int steps = 1;

        while( !q.isEmpty() ){

            int size = q.size();
            boolean found = false;
            // ArrayList<String> toDelete = new ArrayList<>();

            while( size-- > 0 ){

                String originalWord = q.poll();
                char curr[] = originalWord.toCharArray();

                for( int i = 0 ; i < curr.length ; i++ ){
                    char originalChar = curr[i];

                    for( char ch = 'a' ; ch <= 'z' ; ch++ ){

                        if( ch == originalChar ) continue;

                        curr[i] = ch;
                        String newWord  = new String(curr);

                        if (!set.contains(newWord)) continue;

                        if (!stepToReach.containsKey(newWord)) {
                            stepToReach.put(newWord, steps + 1);
                            q.offer(newWord);
                            // toDelete.add(newWord);
                        }

                        // same level parent addition
                        if (stepToReach.get(newWord) == steps + 1) {
                            parent.get(newWord).add(originalWord);
                        }
                    }

                    curr[i] = originalChar;
                }
            }

            steps++;
            if( found ) break;
            // for( String word : toDelete ) set.remove( word );

        }

        dfs( endWord , beginWord , parent , new ArrayList<>() , ans );

        return ans;
    }
}
class Solution {
    
    void dfs( String currentWord , String beginWord, ArrayList<String> currList , List<List<String>> ans ,HashMap<String , ArrayList<String>> parent ){

        if( currentWord.equals( beginWord ) ){
            ArrayList temp = new ArrayList<>(currList);
            Collections.reverse( temp );
            ans.add( temp );
            return;
        }

        for( String neigh : parent.get(currentWord) ){
            currList.add(neigh);
            dfs( neigh , beginWord , currList , ans , parent );
            currList.remove( currList.size() - 1 );
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        HashMap<String , ArrayList<String>> parent = new HashMap<>();
        HashMap<String , Integer> map = new HashMap<>();

        map.put( beginWord , 1 );
        for( String word : wordList ){
            set.add(word);
            parent.put(word , new ArrayList<>());
        }
        if( !set.contains(endWord) )return ans;
        set.add(endWord);
        set.remove(beginWord);
        parent.put(endWord , new ArrayList<>());

        Set<String> currQ = new HashSet<>();
        Set<String> nextQ = new HashSet<>();
        currQ.add(beginWord);

        int steps = 2;

        while( !currQ.isEmpty() ){
            

            for( String originalString : currQ ){

                char[] curr = originalString.toCharArray();
                

                for( int i = 0 ; i < curr.length ; i++ ){
                    char ch = curr[i];
                    for( char c = 'a' ; c <= 'z' ; c++ ){
                        if( c == ch )continue;
                        curr[i] = c;
                        String newString = new String(curr);
                        if( !set.contains( newString ) )continue;

                        if( !map.containsKey(newString) ){
                            map.put( newString , steps );
                        }

                        if( map.get(newString) == steps ){

                            parent.get(newString).add(originalString);

                            if( !newString.equals(endWord) ){
                                nextQ.add( newString );
                            }
                        }
                        
                    }
                    curr[i] = ch;
                }
            }

            HashSet<String> temp = new HashSet<>();
            currQ = nextQ;
            nextQ = temp;

            steps++;
        }
        
        // System.out.println(parent);
        ArrayList temp = new ArrayList<>();
        temp.add(endWord);
        dfs( endWord , beginWord , temp , ans , parent );

        return ans;
    }
}
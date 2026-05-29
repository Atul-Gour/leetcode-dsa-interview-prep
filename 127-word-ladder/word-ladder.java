class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for( String word : wordList ) set.add(word);
        if( !set.contains(endWord) ) return 0;

        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer( beginWord );

        int steps = 0;

        while( !q.isEmpty() ){
            int size = q.size();
            steps++;

            while( size-- > 0 ){
                char[] curr = q.poll().toCharArray();

                for( int i = 0 ; i < curr.length ; i++ ){

                    char original = curr[i];

                    for( char ch = 'a' ; ch <= 'z' ; ch++ ){

                        if( ch == original )continue;

                        curr[i] = ch;
                        String newString = new String(curr);

                        if( newString.equals(endWord) ) return steps + 1;

                        if( set.contains( newString ) ){
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }

                    curr[i] = original;
                }
                
            }
        }

        return 0;
    }
}
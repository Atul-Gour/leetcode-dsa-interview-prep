class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();

        for( String word : wordList ) set.add(word);
        set.remove( beginWord );

        if( !set.contains(endWord) ) return 0;

        q.offer( beginWord );
        int step = 1;

        while( !q.isEmpty() ){
            int size = q.size();

            while( size-- > 0 ){
                char curr[] = q.poll().toCharArray();

                for( int i = 0 ; i < curr.length ; i++ ){
                    char originalChar = curr[i];

                    for( char ch = 'a' ; ch <= 'z' ; ch++ ){

                        if( ch == originalChar ) continue;

                        curr[i] = ch;
                        String newString  = new String(curr);

                        if( newString.equals( endWord ) ) return step + 1;

                        if( set.contains( newString ) ){
                            q.offer( newString );
                            set.remove( newString );
                        }
                    }

                    curr[i] = originalChar;
                }
            }

            step++;
        }

        return 0;

    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordList);
        if( !set.contains(endWord) )return 0;
        Queue<String> q = new ArrayDeque<>();

        q.offer(beginWord);

        int steps = 1;

        while( !q.isEmpty() ){
            int size = q.size();

            while( size-- > 0 ){
                char[] curr = q.poll().toCharArray();

                for( int i = 0 ; i < curr.length ; i++ ){
                    char ch = curr[i];
                    for( char c = 'a' ; c <= 'z' ; c++ ){
                        if( c == ch )continue;
                        curr[i] = c;
                        String newString = new String(curr);
                        if( newString.equals(endWord) )return steps + 1;
                        if( set.contains( newString ) ){
                            q.offer( newString );
                            set.remove( newString );
                        }
                    }
                    curr[i] = ch;
                }
            }
            steps++;
        }
        return 0;
    }
}
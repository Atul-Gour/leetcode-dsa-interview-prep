class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();
        int level = 2;
        HashSet<String> set = new HashSet<>();
        
        for( String s : wordList ){
            set.add(s);
        }

        if( !set.contains(endWord)){
            return 0;
        }
        
        q.offer(beginWord);
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                String curr = q.poll();
                
                for(int i = 0 ; i < curr.length() ; i++){
                    for( char ch = 'a' ; ch <= 'z'  ; ch++ ){
                        String newCurr = curr.substring(0 , i) + ch + curr.substring(i + 1 , curr.length());
                        if(set.contains(newCurr)){
                            
                            if(newCurr.equals(endWord)) return level;
                            
                            q.offer(newCurr);
                            set.remove( newCurr );
                        }
                    }
                }
                
            }
            level++;
        }
        
        return 0;
    }

}
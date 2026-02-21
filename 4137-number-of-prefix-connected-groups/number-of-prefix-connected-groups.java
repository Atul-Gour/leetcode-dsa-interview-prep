class Solution {
    long key(String s, int k) {
        long hash = 0;
        long BASE = 131; 

        for (int i = 0; i < k; i++) {
            hash = hash * BASE + (s.charAt(i) - 'a' + 1);
        }
        return hash;
    }

    public int prefixConnected(String[] words, int k) {
        HashMap<Long , Integer> map = new HashMap<>();
        
        for (String word : words) {
            if (word.length() < k)continue;
            long key = key(word, k);
            
            map.put( key , map.getOrDefault( key , 0 ) + 1 );
            
        }

        int count = 0;

        for (int val : map.values()) {
            if (val <= 1)
                continue;
            
            count++;
        }
        return count;
    }
}
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
        HashMap<Long, ArrayList<String>> map = new HashMap<>();
        for (String word : words) {
            if (word.length() < k)
                continue;
            long key = key(word, k);
            map.computeIfAbsent(key, f -> new ArrayList<>()).add(word);
        }
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for (Long hash : map.keySet()) {
            ArrayList<String> list = map.get(hash);
            int n = list.size();
            if (n <= 1)
                continue;
            
            count++;
        }
        return count;
    }
}
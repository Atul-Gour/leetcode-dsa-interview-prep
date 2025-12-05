class Trie {
    HashSet<String> set1 =new HashSet<>();
    HashSet<String> set2 =new HashSet<>();
    public Trie() {
    }
    
    public void insert(String word) {
        set1.add(word);
        for(int i=0;i<word.length();i++){
            set2.add(word.substring(0,i+1));
        }
        return;
    }
    
    public boolean search(String word) {
        return set1.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        return set2.contains(prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
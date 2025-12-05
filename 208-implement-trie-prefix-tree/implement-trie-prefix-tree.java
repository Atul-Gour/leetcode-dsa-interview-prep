class Trie {
    Trie[] arr;
    boolean isWord; 

    public Trie() {
        arr = new Trie[26];
        isWord = false;
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(char ch: word.toCharArray()){
            if(temp.arr[ch-'a']==null){
                temp.arr[ch-'a']=new Trie();
            }
            temp = temp.arr[ch-'a'];
        }
        temp.isWord=true;
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for(char ch:word.toCharArray()){
            if(temp.arr[ch-'a']==null){
                return false;
            }
            temp = temp.arr[ch-'a'];
        }
        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(char ch:prefix.toCharArray()){
            if(temp.arr[ch-'a']==null){
                return false;
            }
            temp = temp.arr[ch-'a'];
        }
        return true;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
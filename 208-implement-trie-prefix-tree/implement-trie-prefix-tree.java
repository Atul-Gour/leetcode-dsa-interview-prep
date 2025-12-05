class Trie {
    Trie[] arr;
    Boolean isWord; 

    public Trie() {
        arr= new Trie[26];
        isWord =false;
    }
    
    public void insert(String word) {
        Trie temp =this;
        for(char c : word.toCharArray()){
            if(temp.arr[c-'a']==null){
                temp.arr[c-'a'] = new Trie();
            }
            temp = temp.arr[c-'a'];
        }
        temp.isWord =true;
    }
    
    public boolean search(String word) {
        Trie temp =this;
        for(char c : word.toCharArray()){
            if(temp.arr[c-'a']==null){
                return false;
            }
            temp = temp.arr[c-'a'];
        }
        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp =this;
        for(char c : prefix.toCharArray()){
            if(temp.arr[c-'a']==null){
                return false;
            }
            temp = temp.arr[c-'a'];
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
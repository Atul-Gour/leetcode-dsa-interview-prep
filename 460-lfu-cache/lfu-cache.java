class Node{
    int key , val;
    Node prev , next;

    Node( int key , int val ){
        this.key = key;
        this.val = val;
    }
}

class DDL{
    Node tail , head ;

    DDL(){
        this.tail = null;
        this.head = null;
    }

    void addAtLast(Node node){
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    void removeAtHead(){
        if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
            if(head != null)head.prev = null;
        }
    }

    void remove(Node node){
        if( head == node || head == null ){
            removeAtHead();
        }else if(tail == node) {
            tail.prev.next = null;
            tail = tail.prev;
        }else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
    
}

class LFUCache {

    HashMap<Integer , Node> keyNode;
    HashMap<Integer , Integer> keyFreq;
    TreeMap<Integer , DDL> map ;
    int capacity ;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyNode = new HashMap<>();
        this.keyFreq = new HashMap<>();
        this.map = new TreeMap<>();
    }
    
    public int get(int key) {
        if( keyNode.containsKey( key )){

            Node curr = keyNode.get( key );
            put( key , curr.val );
            return curr.val;

        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if( keyNode.containsKey( key )){
            Node curr = keyNode.get( key );
            curr.val = value;
            int currFreq = keyFreq.get( key );
            DDL currDdl = map.get( currFreq );
            currDdl.remove( curr );
            if(currDdl.head == null) map.remove(currFreq);

            keyFreq.put( key , currFreq + 1 );
            map.computeIfAbsent( currFreq + 1 , f -> new DDL() ).addAtLast(curr);
        }else{
            Node newNode = new Node( key , value);
            keyNode.put( key , newNode );
            keyFreq.put( key , 1 );

            if( keyNode.size() > capacity ){

                DDL leastFreq = map.get(map.firstKey());
                Node toDeleteNode = leastFreq.head;
                int toDeleteKey = toDeleteNode.key;
                keyNode.remove( toDeleteKey );
                keyFreq.remove( toDeleteKey );
                leastFreq.removeAtHead();
                if(leastFreq.head == null) map.remove(map.firstKey());
            }
            
            map.computeIfAbsent( 1 , f -> new DDL() ).addAtLast(newNode);
            
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
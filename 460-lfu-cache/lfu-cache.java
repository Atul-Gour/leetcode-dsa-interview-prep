
class Node{
    int key , val;
    Node prev;
    Node next;
    Node(int key , int val){
        this.key = key ;
        this.val = val;
    }
}
class DLL {
    Node head, tail;

    DLL() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    boolean isEmpty() {
        return head.next == tail;
    }

    Node removeLast() {
        if (isEmpty()) return null;
        Node node = tail.prev;
        remove(node);
        return node;
    }
}


class LFUCache {
    
    TreeMap<Integer , DLL> map1 = new TreeMap<>();
    HashMap<Integer , Node> map2 = new HashMap<>();
    HashMap<Integer , Integer> map3 = new HashMap<>();
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map2.containsKey(key))return -1;

        int frequency = map3.get(key);
        Node node = map2.get(key);

        DLL currentDll = map1.get(frequency);
        currentDll.remove(node);

        if(currentDll.isEmpty()){
            map1.remove(frequency);
        }

        frequency++;
        map1.computeIfAbsent(frequency, f -> new DLL()).addFirst(node);
        map3.put(key , frequency);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map2.containsKey(key)){
            Node node = map2.get(key);
            node.val = value;

            int frequency = map3.get(key);

            DLL currentDll = map1.get(frequency);
            currentDll.remove(node);

            if(currentDll.isEmpty()){
                map1.remove(frequency);
            }

            frequency++;
            map1.computeIfAbsent(frequency, f -> new DLL()).addFirst(node);
            map3.put(key , frequency);
        }else{
            if(map2.size() == capacity){
                int toDeleteFrequency = map1.firstKey();
                DLL currentDll = map1.get(toDeleteFrequency);

                int toDeleteKey = currentDll.tail.prev.key;
                currentDll.removeLast();

                if(currentDll.isEmpty())map1.remove(toDeleteFrequency);

                map2.remove(toDeleteKey);
                map3.remove(toDeleteKey);
            }
            Node node = new Node(key , value);
            map1.computeIfAbsent(1, f -> new DLL()).addFirst(node);
            map2.put(key, node);
            map3.put(key , 1);
        }
    }
}
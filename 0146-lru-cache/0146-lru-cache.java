class LRUCache {
    class Node{
        int key, val;
        Node prev, next;

        Node(){
            this.key = -1;
            this.val = -1;
        }

        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    private Node head = new Node(); // next to head mru node
    private Node tail = new Node(); // prev to tail lsu node
    
    private void add(Node nn){
        Node curr = head.next; // add next to head

        nn.next = curr;
        nn.prev = head;

        head.next = nn;
        curr.prev = nn;
    }

    private void remove(Node nn){
        Node nextNode = nn.next;
        Node prevNode = nn.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    int size;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        size = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr = map.get(key);
        remove(curr);
        add(curr); // add next to head

        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);

            curr.val = value;
            add(curr); // add next to head

            map.put(key, curr);
        }else{
            Node node = new Node(key, value);
            add(node);
            map.put(key, node);
        }
        if(map.size() > size){
            Node curr = tail.prev;
            map.remove(curr.key);
            remove(curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    static class Node {
        int val;
        int key;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int limit;
    Node head, tail;
    Map<Integer, Node> hmap;
    public LRUCache(int capacity) {
        this.limit = capacity;
        this.hmap = new HashMap<Integer, Node>();    
    }
    
    public int get(int key) {
        Node node = hmap.get(key);
        if (node != null) {
            remove(node);
            moveToHead(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        // hardest part
        Node node = null;
        if (hmap.containsKey(key)) {
            node = hmap.get(key);
            node.val = value;
            remove(node);
        } else if (hmap.size() < limit){
            node = new Node(key, value);     
        } else {
            node = new Node(key, value);  
            remove(tail);
        }
        moveToHead(node);
    }
    
    private void moveToHead(Node node) {
        hmap.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = head.prev;   
        }

    }
    
    private void remove(Node node) {
        hmap.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail= tail.prev;
        }
        node.next = node.prev = null;
    } 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

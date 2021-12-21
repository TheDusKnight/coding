package leetcode._0706_DesignHashMap;

// 自定义list node, 最好的做法
class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes;
    private static final int RANGE = 2069;
    public MyHashMap() {
        nodes = new Node[RANGE];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(-1,-1); // 必须初始化并赋值
    }
    
    private int _hash(int key) {
        return key % RANGE;
    }
    
    public void put(int key, int value) {
        int idx = _hash(key);
        Node prev = findPrev(nodes[idx], key);
        if (prev.next == null) prev.next = new Node(key, value);
        else prev.next.val = value;
    }
    
    public int get(int key) {
        int idx = _hash(key);
        Node prev = findPrev(nodes[idx], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int idx = _hash(key);
        Node prev = findPrev(nodes[idx], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    private Node findPrev(Node root, int key) {
        Node cur = root, prev = null;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

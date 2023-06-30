package leetcode._0707_DesignLinkedList;

// doubly linked list简写
class MyLinkedList3 {
    ListNode head, tail;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList3() {
        size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) cur = cur.next;
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode prev = head, next = head.next;
        
        add(prev, next, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode next = tail, prev = tail.prev;
        
        add(prev, next, val);
    }
    
    private void add(ListNode prev, ListNode next, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = next;
        newNode.prev = prev;
        next.prev = newNode;
        prev.next = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        
        ListNode prev = head;
        for (int i = 0; i < index; i++) prev = prev.next;
        ListNode next = prev.next;
        
        add(prev, next, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        ListNode prev = head;
        for (int i = 0; i < index; i++) prev = prev.next;
        ListNode next = prev.next.next;
        
        prev.next = next;
        next.prev = prev;
        size--;
    }
}

class ListNode {
    int val;
    ListNode prev, next;
    
    public ListNode() {
        this(0);
    }
    
    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

package leetcode._0707_DesginLinkedList;

class MyLinkedList2 {
    int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    ListNode head, tail;
    
    /** Initialize your data structure here. */
    public MyLinkedList2() {
        size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;
        
        // choose the fastest way to move from the head or to move from the tail
        ListNode curr = head;
        if (index + 1 < size - index) {
            for (int i = 0; i < index+1; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = 0; i < size-index; i++) curr = curr.prev;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode prev = head, next = head.next;
        
        size++;
        ListNode add = new ListNode(val);
        add.prev = prev;
        add.next = next;
        prev.next = add;
        next.prev = add;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode next = tail, prev = tail.prev;
        
        size++;
        ListNode add = new ListNode(val);
        add.prev = prev;
        add.next = next;
        prev.next = add;
        next.prev = add;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        
        // find predecessor and successor of the node to be added
        ListNode prev, next;
        if (index < size - index) { // 分类讨论缩短时间
            prev = head;
            for (int i = 0; i < index; i++) prev = prev.next;
            next = prev.next;
        } else {
            next = tail;
            for (int i = 0; i < size - index; i++) next = next.prev;
            prev = next.prev;
        }
        
        size++; // size必须加在后面
        // insertion itself
        ListNode add = new ListNode(val);
        add.next = next;
        add.prev = prev;
        next.prev = add;
        prev.next = add;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        size--;
        // find predecessor and successor of the node to be deleted
        ListNode prev, next;
        if (index < size - index) {
            prev = head;
            for (int i = 0; i < index; i++) prev = prev.next;
            next = prev.next.next;
        } else {
            next = tail;
            for (int i = 0; i < size - index; i++) next = next.prev;
            prev = next.prev.prev;
        }
        
        prev.next = next;
        next.prev = prev;
    }
}

class ListNode {
    ListNode prev;
    ListNode next;
    int val;
    
    public ListNode() {
        val = 0;
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

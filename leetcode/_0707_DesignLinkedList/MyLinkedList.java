package leetcode._0707_DesignLinkedList;

// singly linked list
class MyLinkedList {
    int size;
    ListNode dummy;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        dummy = new ListNode(); // sentinel node as pseudo-head
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;
        
        ListNode cur = dummy;
        index++;
        while (index-- > 0) cur = cur.next;
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val); // reuse method
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0; // 跟面试官澄清
        
        size++;
        // find predecessor of the node to be added
        ListNode pred = dummy;
        while (index-- > 0) pred = pred.next;
        // node to be added
        ListNode add = new ListNode(val);
        // insertion itself
        add.next = pred.next;
        pred.next = add;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;
        
        size--;
        ListNode pred = dummy;
        while (index-- > 0) pred = pred.next;
        pred.next = pred.next.next;
    }
}

// class ListNode {
//     private static final int DEFAULT_VALUE = 0;
//     int val;
//     ListNode next;
    
//     public ListNode() {
//         val = DEFAULT_VALUE;
//     }
    
//     public ListNode(int x) {
//         val = x;
//     }
// }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

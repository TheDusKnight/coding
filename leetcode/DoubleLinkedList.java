package leetcode;

public class DoubleLinkedList {
    // fields
    ListNode head;
    ListNode tail;
    int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private int getVal(int index) {
        if (index < 0 || head == null || index >= size) {
            throw new IllegalArgumentException("getVal");
        } else {
            while (index-- > 0) {
                head = head.next;
            }
            return head.val;
        }
    }

    private void addHead(int val) {
        ListNode newHead = new ListNode(val);
        if (head == null) {
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }

    private void addTail(int val) {
        ListNode newTail = new ListNode(val);
        if (head == null) {
            tail = newTail;
        } else {
            newTail.prev = tail;
            tail.next = newTail;
        }
        tail = newTail;
        size++;
    }

    private int getSize() {
        return size;
    }
}

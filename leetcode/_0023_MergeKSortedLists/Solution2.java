package leetcode._0023_MergeKSortedLists;

import leetcode.ListNode;

// Merge with divide and conquer
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1; // 初始化区间为1
        while (interval < lists.length) {
            // 每次指定区间两两合并
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    // private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) return l2;
    //     if (l2 == null) return l1;

    //     if (l1.val < l2.val) {
    //         l1.next = mergeTwoLists(l1.next, l2);
    //         return l1;
    //     } else {
    //         l2.next = mergeTwoLists(l1, l2.next);
    //         return l2;
    //     }
    // }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head, cur;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return head;
    }
}

// time: 一共有N个node，k个链表，每次所有node都要touch一次，每次两两merge，一共做log(k)次。所以O(N*log(k))
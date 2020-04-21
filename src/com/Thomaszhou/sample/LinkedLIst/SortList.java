package com.Thomaszhou.sample.LinkedLIst;
/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
 */
public class SortList {
    // merge sort recursive. n steps to get to the middle. sort each part. then merge them (merge 2 sorted linkedList)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l1 = head, l2 = slow.next;
        slow.next = null; // split the list into two

        l1 = sortList(l1); l2 = sortList(l2);

        return MergeTwoSortedLinkedList.mergeTwoLists(l1, l2);
    }
}

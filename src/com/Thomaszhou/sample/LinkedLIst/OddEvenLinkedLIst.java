package com.Thomaszhou.sample.LinkedLIst;

import com.Thomaszhou.sample.LinkedLIst.ListNode;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedLIst {
    //Put the odd nodes in a linked list and the even nodes in another. Then link the evenList to the tail of the oddList.
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = null;
        if (head.next != null) {
            evenHead = head.next;
        }

        boolean odd = true;
        ListNode oddTail = null;
        ListNode next;
        ListNode cur = head;


        while(cur instanceof ListNode){
            next = cur.next; // saving a pointer to current next

            if (cur.next != null) cur.next = cur.next.next;
            else cur.next = null;

            if (odd && cur.next == null){
                oddTail = cur;
            }
            odd = !odd;

            cur = next;
        }
        oddTail.next = evenHead;

        return head;
    }
}

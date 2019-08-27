package com.Thomaszhou.sample;

public class ReverseLinkedList {
    /*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?*/

    public static ListNode reverseList(ListNode head) {
        // USE STACK

        // if (head == null) return head;
        // ListNode temp = head;
        // Stack<ListNode> stack = new Stack();
        // while(temp != null){
        //     stack.push(temp);
        //     temp = temp.next;
        // }
        // temp = stack.pop();
        // head = temp;
        // while (!stack.isEmpty()){
        //     temp.next = stack.pop();
        //     temp = temp.next;
        // }
        // temp.next = null;
        // return head;

        // ITERATIVE with prev and next

        // if (head == null){
        //     return head;
        // }
        // ListNode prev = null;
        // ListNode cur = head;
        // ListNode next = cur.next;
        // while(cur!=null){
        //     next = cur.next;
        //     cur.next = prev;
        //     prev = cur;
        //     cur = next;
        // }
        // return prev;

        //RECURSIVE
        //Need to think backward assume everything after is reversed.
//       Example : 1->2->3<-4<-5 we @3


        if(head == null || head.next == null){ return head;}
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}

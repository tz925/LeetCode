package com.Thomaszhou.sample.LinkedLIst;

import com.Thomaszhou.sample.LinkedLIst.ListNode;

public class LinkedListPalindrome {
    private static ListNode reverse(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = slow;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        slow = reverse(slow);

        while(head != null && slow != null) {
            if(head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
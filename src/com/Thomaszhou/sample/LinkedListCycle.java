package com.Thomaszhou.sample;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> haveSeen = new HashSet<>();
//        while(head != null){
//            if(haveSeen.contains(head)){
//                return true;
//            }else{
//                haveSeen.add(head);
//                head = head.next;
//            }
//        }
//        return false;
//    }

    // if cycle, imagine two runners running a circuit.
    // time(n) space(1)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}

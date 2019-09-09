package com.Thomaszhou.sample;

public class LinkedListCycleII {
    // from start to start of cycle is A, from start of cycle to meet point is B.
    // slow has moved A+B and fast must moved 2(A+B) to meet point
    //which means cycle length N = A+B.
    // from meet point to start of cycle is N - B = A. A is also the distance from start of list to start of cycle.
    // so use another slow pointer, A = steps two slow pointers meet again.
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow2 = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                while(slow!= slow2){
                    slow = slow.next;
                    slow2 = slow2.next;

                }
                return slow;
            };
        }
        return null;
    }

    // or use Set to record seen nodes, but it takes extra space. first seen node will be the start node.
}

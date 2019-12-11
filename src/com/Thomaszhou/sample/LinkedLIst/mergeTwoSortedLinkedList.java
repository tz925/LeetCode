package com.Thomaszhou.sample.LinkedLIst;


import com.Thomaszhou.sample.LinkedLIst.ListNode;

public class mergeTwoSortedLinkedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, cur, cur1, cur2;
        if(l1 == null && l2 == null){
            return null;
        }else if (l1 == null){return l2;}
        else if (l2 == null){return l1;}
        else{
            if(l1.val <= l2.val){
                head = l1;
                cur = head;
                cur1 = l1.next;
                cur2 = l2;
            }else{
                head = l2;
                cur = head;
                cur1 = l1;
                cur2 = l2.next;
            }
        }
        while (cur1 != null || cur2 != null){
            if(cur1 == null){
                cur.next = cur2;
                break;
            }else if(cur2 == null){
                cur.next = cur1;
                break;
            }else{
                if(cur1.val <= cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                    cur = cur.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
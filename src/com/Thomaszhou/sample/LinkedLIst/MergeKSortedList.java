package com.Thomaszhou.sample.LinkedLIst;

import com.Thomaszhou.sample.LinkedLIst.ListNode;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList {
    // perform merge 2 sorted linked list on every two lists.
    public ListNode mergeKLists(ListNode[] lists) {
        int amount = lists.length;
        int interval = 1;
        while(interval < amount){
            for (int i = 0; i < amount-interval; i+=interval*2) {
                lists[i] = MergeTwoSortedLinkedList.mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
}

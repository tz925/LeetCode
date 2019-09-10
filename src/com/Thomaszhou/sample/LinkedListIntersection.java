package com.Thomaszhou.sample;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

begin to intersect at node c1.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

Example 2:

Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

Example 3:

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class LinkedListIntersection {
    // use one set to store seen node in B(orA). for each node in A(orB) check to see if there is a seen node. the
    // first seen node is the intersection node. time(m+n) space(n)or space(m) but in Notes it says O(1) space. so we have to have
    // another solution which should only use constant amount of pointers.


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if pB reached end first, point it to headA, vise versa.
        // if pB were 2 steps quicker to the end, it means, pA will be 2 step quicker when pA start again at headB.
        // even out the 2 step difference. then they are guranteed to meet at the intersection.
        ListNode pA, pB, lastA, lastB;
        pA = headA;
        pB = headB;
        lastA = null;
        lastB = null;
        while(pA != null && pB != null){
            if (pA == pB) return pA;
            if(pA.next == null) {
                if (lastA == null) lastA = pA;
                else {
                    if (lastA != lastB) return null;
                }
                pA = headB;
                pB = pB.next;
            }else if(pB.next == null){
                if (lastB == null) lastB = pB;
                else {
                    if (lastB != lastA) return null;
                }
                pB = headA;
                pA = pA.next;
            }else{
                pA = pA.next;
                pB = pB.next;
            }
        }
        return null;
    }
}

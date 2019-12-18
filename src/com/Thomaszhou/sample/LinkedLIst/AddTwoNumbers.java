package com.Thomaszhou.sample.LinkedLIst;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null, head = null;
        int carry = 0;
        int value;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a+b+carry;
            carry = sum/10;
            value = sum % 10;
            ListNode cur = new ListNode(value);

            if (head == null) head = cur;
            if (temp != null) temp.next = cur;
            temp = cur;

        }
        if (carry != 0) {
            ListNode lastone = new ListNode(carry);
            temp.next = lastone;
        }

        return head;
    }
}

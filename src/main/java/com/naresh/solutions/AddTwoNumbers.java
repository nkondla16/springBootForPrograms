package com.naresh.solutions;


/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args){

        ListNode l1 = new ListNode(4, new ListNode(4, new ListNode(6)));

        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(2)));

        ListNode res = addTwoNumbers(l1, l2);


        while (res != null){

            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode  addTwoNumbers(ListNode l1 , ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q=l2, curr = dummyHead;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            curr = curr.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

        }
            if ( carry >0){
                curr.next = new ListNode(carry);
            }
            return  dummyHead.next;
        }

}

class ListNode {
    int val;
    ListNode next;


    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

/*
Complexity Analysis

Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively,
 the algorithm above iterates at most \max(m, n)max(m,n) times.

Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
 */
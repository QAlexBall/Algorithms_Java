package LeetCode;


import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 */
public class AddTwoNumbers2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        int count1 = 0, count2 = 0;
        while(l1 != null) {
            hash1.put(++count1, l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            hash2.put(++count2, l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stack = new Stack<>();
        int fc = 0;


        ListNode l3 = new ListNode(0);
        return l3;
    }
    public static ListNode addTwoNumbers_pass(ListNode l1, ListNode l2) {
         ListNode l3 = new ListNode(0);
         Stack<ListNode> stack1 = new Stack<>();
         Stack<ListNode> stack2 = new Stack<>();
         while(l1.next != null) {
             stack1.push(l1);
             l1 = l1.next;
         }
         stack1.push(l1);

         while(l2.next != null) {
             stack2.push(l2);
             l2 = l2.next;
         }
         stack2.push(l2);

         ListNode p = l3;
         int fc = 0;
         int value = stack1.pop().val + stack2.pop().val;
         if(value >= 10) {
             fc = 1;
         }
         p.next = new ListNode(value % 10);
         p = p.next;

         while(!stack1.empty() && !stack2.empty()) {
             value = stack1.pop().val + stack2.pop().val + fc;
             if(value >= 10) {
                 fc = 1;
             } else {
                 fc = 0;
             }
             p.next = new ListNode(value % 10);
             p = p.next;
         }
        while (!stack1.empty()) {
            value = stack1.pop().val + fc;
            p.next = new ListNode(value % 10);
            p = p.next;
            if (value >= 10) {
                fc = 1;
            } else {
                fc = 0;
            }
        }
         while(!stack2.empty()) {
             value = stack2.pop().val + fc;
             p.next = new ListNode(value %10);
             p = p.next;
             if(value >= 10) {
                 fc = 1;
             } else {
                 fc = 0;
             }
         }
         if(fc == 1) {
             p.next = new ListNode(1);
         }

         l3 = l3.next;
         Stack<ListNode> stack = new Stack<>();
         while(l3 != null) {
             stack.push(l3);
             l3 = l3.next;
         }
         ListNode res = new ListNode(stack.pop().val);
         ListNode s = res;
         while(!stack.empty()) {
             s.next = new ListNode(stack.pop().val);
             s = s.next;
         }
         return res;
     }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode p = l1;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode q = l2;
        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(4);

        ListNode l3 = addTwoNumbers_pass(l1, l2);
        while(l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}

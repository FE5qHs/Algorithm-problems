/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode res = l1;
        ListNode pre = null;
        while (null != l1 && null != l2) {
            l1.val += l2.val;
            if (null == l1.next) pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (null != l2) pre.next = l2;

        boolean next = false;
        ListNode t = res;
        while (null != t) {
            if (next) {
                t.val += 1;
                next = false;
            }
            if (t.val > 9) {
                t.val -= 10;
                next = true;
            }
            if (null == t.next) pre = t;
            t = t.next;
        }
        if (next) pre.next = new ListNode(1);

        return res;
    }
}
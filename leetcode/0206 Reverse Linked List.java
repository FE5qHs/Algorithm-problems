/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode a = head, b = head.next, c = head.next.next;
        while (null != c) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
        head.next = null;
        return b;
    }
}
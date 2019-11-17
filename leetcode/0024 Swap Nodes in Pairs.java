/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs1(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode res = head.next, h = null, p = head, q = p.next;
        while (null != q) {
            p.next = q.next;
            q.next = p;
            if (null != h) h.next = q;
            h = p;
            p = p.next;
            if (null == p) break;
            q = p.next;
        }
        return res;
    }
    // recursive solution
    public ListNode swapPairs2(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}
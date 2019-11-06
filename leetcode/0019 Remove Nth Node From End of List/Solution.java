/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, back = head;
        for (int i = 0; i < n; i++) {
            back = back.next;
        }
        if (null == back) {
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
        while (null != back.next) {
            front = front.next;
            back = back.next;
        }
        ListNode temp = front.next;
        front.next = temp.next;
        return head;
    }
}
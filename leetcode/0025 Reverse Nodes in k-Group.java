class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || k < 2) return head;
        ListNode end = head;
        for (int i = 0; i < k - 1; ++i) {
            end = end.next;
            if (null == end) return head;
        }
        ListNode nextHead = end.next;
        helper(head, end);
        head.next = reverseKGroup(nextHead, k);
        return end;
    }

    private ListNode helper(ListNode head, ListNode end) {
        if (end == head) return head;
        ListNode newHead = helper(head.next, end);
        head.next.next = head;
        return newHead;
    }
}
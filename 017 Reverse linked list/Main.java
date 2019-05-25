/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        } else if (null == head.next) {
            return head;
        } else if (null == head.next.next) {
            ListNode result = head.next;
            head.next = null;
            result.next = head;
            return result;
        }

        ListNode a = head, b = a.next, c = b.next;
        a.next = null;
        while (null != c) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
        return b;
    }
}
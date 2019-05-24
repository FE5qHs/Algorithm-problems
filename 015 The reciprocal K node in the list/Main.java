/*
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (null == head) {
            return null;
        }
 
        int len = 0;
        ListNode h = head;
        while (null != h) {
            ++len;
            h = h.next;
        }
 
        if (len < k) {
            return null;
        } else {
            for (int i = 0; i < len - k; ++i) {
                head = head.next;
            }
            return head;
        }
    }
}
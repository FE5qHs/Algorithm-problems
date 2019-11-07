/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null, result = null;
        while (null != l1 && null != l2) {
            if (l1.val >= l2.val) {
                ListNode l2Next = l2.next;
                if (null != res) {
                    res.next = l2;
                }
                res = l2;
                if (null == result) result = res;
                l2 = l2Next;
            } else {
                ListNode l1Next = l1.next;
                if (null != res) {
                    res.next = l1;
                }
                res = l1;
                if (null == result) result = res;
                l1 = l1Next;
            }
        }
        if (null != l1) {
            if (null != res) {
                res.next = l1;
            } else {
                result = l1;
            }
        } else if (null != l2) {
            if (null != res) {
                res.next = l2;
            } else {
                result = l2;
            }
        }
        return result;
    }
}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (null == list1) {
            return list2;
        } else if (null == list2) {
            return list1;
        }

        ListNode result = list1;
        ListNode pre = null;
        while (null != list1 && null != list2) {
            if (list1.val > list2.val) {
                pre = list1;
                list1 = list1.next;
            } else {
                ListNode temp = list1.next;
                list1.next = list2;
                list2 = list2.next;
                list1.next.next = temp;
                pre = list1.next;
                list1 = temp;
            }
        }

        if (null == list1 && null != list2) {
            pre.next = list2;
        }

        return result;
    }
}
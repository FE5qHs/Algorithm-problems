/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (null == pHead || null == pHead.next) {
            return null;
        }

        int i = 2;
        ListNode[] list = new ListNode[i];
        list[0] = pHead;
        list[1] = pHead.next;
        pHead = pHead.next;
        while (null != pHead) {
            for (int j = 0; j < i; ++j) {
                if (list[j] == pHead.next) {
                    return pHead.next;
                }
            }
            ListNode[] newList = new ListNode[++i];
            System.arraycopy(list, 0, newList, 0, i - 1);
            newList[i - 1] = pHead.next;
            pHead = pHead.next;
            list = newList;
        }

        return null;
    }
}
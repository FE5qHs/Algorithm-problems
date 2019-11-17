/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode least = null;
        int countNotNull = 0;
        int leastNodeIdx = 0;
        for (int i = 0; i < lists.length; ++i) {
            if (null != lists[i]) {
                leastNodeIdx = i;
                least = lists[i];
                ++countNotNull;
            }
        }
        if (null == least || 1 == countNotNull) return least;
        for (int i = 0; i < lists.length; ++i) {
            if (null != lists[i] && lists[i].val < least.val) {
                leastNodeIdx = i;
                least = lists[leastNodeIdx];
            }
        }
        lists[leastNodeIdx] = lists[leastNodeIdx].next;
        least.next = mergeKLists(lists);
        return least;
    }
}
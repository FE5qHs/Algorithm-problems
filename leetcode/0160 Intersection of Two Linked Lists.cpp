/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int aLen = 0;
        for (ListNode *temp = headA; temp != nullptr; temp = temp->next) {
            ++aLen;
        }
        int bLen = 0;
        for (ListNode *temp = headB; temp != nullptr; temp = temp->next) {
            ++bLen;
        }
        
        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; ++i) {
                headA = headA->next;
            }
        } else {
            for (int i = 0; i < bLen - aLen; ++i) {
                headB = headB->next;
            }
        }
        while (headA != nullptr) {
            if (headA == headB) return headA;
            headA = headA->next;
            headB = headB->next;
        }
        
        return nullptr;
    }
};
# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def deleteDuplication(self, pHead):
        if pHead is None:
            return None
        node = pHead
        while node.next is not None:
            if node.val is node.next.val:
                # if duplication exists,delete all duplications
                # node.next need to be check because traversal may reach end of linked list
                while node.next is not None and node.val is node.next.val:
                    temp = node.next
                    node.next = temp.next
                # delete first duplication,if next exists,cover it with next node
                if node.next is not None:
                    temp = node.next
                    node.val = temp.val
                    node.next = temp.next
                # if next not exist,then need to traverse from pHead again to delete it
                else:
                    # if all node stores duplication,None is returned
                    temp = pHead
                    if temp is node:
                        return None
                    else:
                        # delete first duplication normally
                        while temp.next is not node:
                            temp = temp.next
                        temp.next = None
                        node = temp
            else:
                node = node.next
        return pHead

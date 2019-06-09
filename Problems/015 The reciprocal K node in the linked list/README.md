# The reciprocal K node in the linked list
[The reciprocal K node in the linked list](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## Technique

链表中的查找 替换等操作常使用多个指针进行 如长度为n 找出第k个节点 可以让两个距离为k的指针前进直到结尾 将链表分成n-k与k两段

考虑边界问题时主要考虑输入参数导致错误的情况 如参数为null 正负数等情况
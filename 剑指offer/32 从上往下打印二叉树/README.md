# Description

[从上往下打印二叉树](https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

# Technique

涉及指针操作时，注意判断指针为null的情况

有向图的广度优先遍历跟层次遍历的思想是一样的：把起始结点放入队列尾部，每次从头部取出结点，访问后把它能达到的结点依次放入队列，重复直到队列为空
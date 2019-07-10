# Description

[二叉搜索树与双向链表](https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

# Introspection

充分利用树的递归特性：

1. 我的思路：二叉树的递归特性是遍历的基础，用额外的变量追踪遍历过程构建需要的连接。

2. 剑指offer的思路：将问题分解成三个子问题：如何处理左子树，根节点，右子树？并将子问题的解决方法递归地应用到整个树。我认为这是一种更系统，更清晰，更好地利用了树的递归特性的思路。
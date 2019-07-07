# Description

[二叉树中和为某一值的路径](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

# Introspection

具体见代码，不足之处主要分为两点

1. 对于root为null的处理，不需要添加新的函数，在函数开始添加null判断并将result和path设为solution类的变量即可，如该函数收到根节点为参数，则直接返回结果result，如该函数收到叶节点为参数，返回结果给上一层函数，上一层函数不做处理，没有任何影响。

2. 对于深度优先遍历树类型的题目，如何解决参数为引用并且下一函数修改参数导致其余函数收到被“污染”过的参数的问题？如范例代码中展示的，在深度减少前最后一步进行回撤修改的操作，可以使参数保持“纯净”。
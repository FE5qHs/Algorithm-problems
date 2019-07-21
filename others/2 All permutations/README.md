# Description

Given a string,generate all possible permutations of chars in string.

# Introspection

采取挨个选取原字符串中的字符，复制，以此构建新字符串的方法适用于需要把新字符串存储起来的情况。
如果只是要求把新字符串打印出来，交换原字符串内的字符会是更好的选择：依旧采取老方法的话则复制过程变为多余，降低了时间效率。
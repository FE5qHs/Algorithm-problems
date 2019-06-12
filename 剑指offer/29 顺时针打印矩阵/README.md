# Description

[顺时针打印矩阵](https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

# Introspection

我常用的思维方法：先写出适用于大部分样例的代码，然后针对特例依次修改代码，结果常出现一种情况：针对后来的样例修改的代码不适用于前面的样例，只能慢慢试错。

正确的做法：先找出所有的样例种类，将其按类别归类，编码处理各种类型（常有自己想不到的样例类型，该方法是否真的实用？我想应当比我的思路更好）。

具体到该题目：总结出所有类型之后，找出了类别之间的关系为递进，按该特点编写了代码（剑指offer第二版163页第二段落）。

# Technique

ceil(x)的简便方法：(x-1)/2+1
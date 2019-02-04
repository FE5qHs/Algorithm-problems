#include <iostream>

using namespace std;

struct BinaryTreeNode
{
    int value;
    BinaryTreeNode * left_node;
    BinaryTreeNode * right_node;
};
/*
* Author: angcz
* Function: build a binary tree according to its preorder traversal and inorder traversal
* Parameters: BTN:the root node of the binary tree,the node doesn't need to be initialized
*             and will be changed in the function
*
*             pre:the array that stores preorder traversal of the binary tree
*
*             in:the array that stores inorder traversal of the binary tree
*
*             len:the length of pre and in
* Modified : 2018/3/15
*/
void build_tree(BinaryTreeNode * & BTN, int * pre, int * in, int len)
{
    if (pre == nullptr || in == nullptr)
    {
        BTN = new BinaryTreeNode;
        BTN->value = -1;
        BTN->left_node = nullptr;
        BTN->right_node = nullptr;
        return;
    }

    if (len == 1)
    {
        BTN = new BinaryTreeNode;
        BTN->value = pre[0];
        BTN->left_node = nullptr;
        BTN->right_node = nullptr;
        return;
    }

    int in_node = 0;
    for (int i = 0; i < len; ++i)
        if (pre[0] == in[i])
            in_node = i;

    int *left_part_pre, *left_part_in, *right_part_pre, *right_part_in;

    BTN = new BinaryTreeNode;
    BTN->value = pre[0];

    if (in_node == 0)
        left_part_pre = nullptr;
    else
    {
        left_part_pre = new int[in_node];
        for (int i = 1, j = 0; i <= in_node; ++i, ++j)
            left_part_pre[j] = pre[i];
    }

    if (in_node == 0)
        left_part_in = nullptr;
    else
    {
        left_part_in = new int[in_node];
        for (int i = 0; i < in_node; ++i)
            left_part_in[i] = in[i];
    }

    if (in_node == len - 1)
        right_part_pre = nullptr;
    else
    {
        right_part_pre = new int[len - in_node - 1];
        for (int i = in_node + 1, j = 0; i < len; ++i, ++j)
            right_part_pre[j] = pre[i];
    }

    if (in_node == len - 1)
        right_part_in = nullptr;
    else
    {
        right_part_in = new int[len - in_node - 1];
        for (int i = in_node + 1, j = 0; i < len; ++i, ++j)
            right_part_in[j] = in[i];
    }

    build_tree(BTN->left_node, left_part_pre, left_part_in, in_node);
    build_tree(BTN->right_node, right_part_pre, right_part_in, len - 1 - in_node);
}
/*
* Author: angcz
* Function: preorder traverse a binary tree and output its value of node
* Parameters: the root node of binary tree
* Modified : 2018/3/15
*/
void print_bt_pre(BinaryTreeNode * BTN)
{
    if (BTN == nullptr)
        return;
    cout << "value: " << BTN->value << endl;
    print_bt_pre(BTN->left_node);
    print_bt_pre(BTN->right_node);
}
/*
* Author: angcz
* Function: inorder traverse a binary tree and output its value of node
* Parameters: the root node of binary tree
* Modified : 2018/3/15
*/
void print_bt_in(BinaryTreeNode * BTN)
{
    if (BTN == nullptr)
        return;
    print_bt_in(BTN->left_node);
    cout << "value: " << BTN->value << endl;
    print_bt_in(BTN->right_node);
}

int main()
{
    //So many problems in this program,memory leak,inappropriate dealing with empty node...
    //should be improved when review
    int pre[] = { 1,2,3,4,5,6,7,8,10,9,11 };
    int in[] = { 4,3,2,5,6,1,8,10,7,9,11 };
    BinaryTreeNode * BTN = nullptr;
    build_tree(BTN, pre, in, sizeof(pre) / sizeof(int));
    print_bt_pre(BTN);
    cout << endl;
    print_bt_in(BTN);
    cin.get();
}
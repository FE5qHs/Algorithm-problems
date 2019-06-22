package com;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        d.right = f;
        e.left = g;

        PrintFromTopToBottom(a);
    }

    static private void PrintFromTopToBottom(TreeNode root) {
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> l1 = new LinkedList<>();
        LinkedList<TreeNode> l2 = new LinkedList<>();
        l1.add(root);
        while (l1.size() != 0) {
            TreeNode n = l1.getFirst();
            l1.remove(0);
            System.out.print(n.val);
            if (null != n.left) {
                l2.add(n.left);
            }
            if (null != n.right) {
                l2.add(n.right);
            }
            if (0 == l1.size()) {
                System.out.println();
                l1.addAll(l2);
                l2.clear();
            }
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }
}
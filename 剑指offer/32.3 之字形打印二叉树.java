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
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);
        TreeNode k = new TreeNode(11);
        TreeNode l = new TreeNode(12);
        TreeNode m = new TreeNode(13);
        TreeNode n = new TreeNode(14);
        TreeNode o = new TreeNode(15);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        d.left = h;
        d.right = i;
        e.left = j;
        e.right = k;
        f.left = l;
        f.right = m;
        g.left = n;
        g.right = o;

        PrintFromTopToBottom(a);
    }

    static private void PrintFromTopToBottom(TreeNode root) {
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        int curLayerNode = 1;
        int nextLayerNode = 0;
        boolean isLeftToRight = true;
        while (l.size() != 0) {
            TreeNode n;
            if (isLeftToRight) {
                n = l.getFirst();
                l.remove(0);

                if (null != n.left) {
                    l.addLast(n.left);
                    ++nextLayerNode;
                }
                if (null != n.right) {
                    l.addLast(n.right);
                    ++nextLayerNode;
                }
            } else {
                n = l.getLast();
                l.remove(l.size() - 1);

                if (null != n.right) {
                    l.addFirst(n.right);
                    ++nextLayerNode;
                }
                if (null != n.left) {
                    l.addFirst(n.left);
                    ++nextLayerNode;
                }
            }
            --curLayerNode;
            System.out.print(n.val);

            if (0 == curLayerNode) {
                System.out.println();
                curLayerNode = nextLayerNode;
                nextLayerNode = 0;
                isLeftToRight = !isLeftToRight;
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
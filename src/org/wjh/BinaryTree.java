package org.wjh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode<Integer> root = new TreeNode<Integer>(0);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        nlr2(root);
        System.out.println();
        lnr2(root);
        System.out.println();
        lrn2(root);
        System.out.println();
        level(root);
        System.out.println("=====hight=====");
        System.out.println(hight(root));
    }

    public static <T> void nlr(TreeNode<T> node) {
        if(node != null) {
            System.out.print(node.data + ", ");
            nlr(node.left);
            nlr(node.right);
        }
    }

    public static <T> void lnr(TreeNode<T> node) {
        if(node != null) {
            lnr(node.left);
            System.out.print(node.data + ", ");
            lnr(node.right);
        }
    }

    public static <T> void lrn(TreeNode<T> node) {
        if(node != null) {
            lrn(node.left);
            lrn(node.right);
            System.out.print(node.data + ", ");
        }
    }

    public static <T> void deep(TreeNode<T> node) {
        if(node != null) {
            System.out.print(node.data + ", ");
            deep(node.left);
            deep(node.right);
        }
    }

    public static <T> int hight(TreeNode<T> node) {
        if(node == null) {
            return 0;
        }
        int left = hight(node.left);
        int right = hight(node.right);
        return left >= right? left + 1 : right + 1;
    }

    public static <T> void level(TreeNode<T> node) {
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + ", ");
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static <T> void nlr2(TreeNode<T> node) {
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        while(node != null || !s.isEmpty()) {
            if(node != null) {
                s.push(node);
                System.out.print(node.data + ", ");
                node = node.left;
            }else {
                node = s.pop();
                node = node.right;
            }
        }
    }

    public static <T> void lnr2(TreeNode<T> node) {
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        while(node != null || !s.isEmpty()) {
            if(node != null) {
                s.push(node);
                node = node.left;
            }else {
                node = s.pop();
                System.out.print(node.data + ", ");
                node = node.right;
            }
        }
    }

    public static <T> void lrn2(TreeNode<T> node) {
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        Stack<TreeNode<T>> t = new Stack<TreeNode<T>>();
        while(node != null || !s.isEmpty()) {
            if(node != null) {
                s.push(node);
                t.push(node);
                node = node.right;
            }else {
                node = s.pop();
                node = node.left;
            }
        }
        while(!t.isEmpty()) {
            System.out.print(t.pop().data + ", ");
        }
    }

    public static <T> void deep2(TreeNode<T> node) {
        Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
        while(node != null || !s.isEmpty()) {
            if(node != null) {
                System.out.print(node.data + ", ");
                s.push(node);
                node = node.left;
            }else {
                node = s.pop();
                node = node.right;
            }
        }
    }
} 

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}

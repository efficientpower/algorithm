package org.wjh;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Hello {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       TreeNode<Integer> node3 = new TreeNode<Integer>(3, null,null);
       TreeNode<Integer> node4 = new TreeNode<Integer>(4, null,null);
       TreeNode<Integer> node5 = new TreeNode<Integer>(5, null,null);
       TreeNode<Integer> node2 = new TreeNode<Integer>(2, node5,null);
       TreeNode<Integer> node1 = new TreeNode<Integer>(1, node3,node4);
       TreeNode<Integer> root = new TreeNode<Integer>(0, node1,node2);
       lrn2(root);
    }

    public static void nlr(TreeNode<Integer> node) {
        if(node != null) {
            System.out.print(node.getData() + ", ");
            nlr(node.left);
            nlr(node.right);
        }
    }

    public static void lnr(TreeNode<Integer> node) {
        if(node != null) {
            lnr(node.left);
            System.out.print(node.getData() + ", ");
            lnr(node.right);
        }
    }

    public static void lrn(TreeNode<Integer> node) {
        if(node != null) {
            lrn(node.left);
            lrn(node.right);
            System.out.print(node.getData() + ", ");
        }
    }

    public static void nlr2(TreeNode<Integer> node) {
        if(node != null) {
            Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
            while(node != null || s.size() > 0) {
                while(node != null) {
                    s.push(node);
                    System.out.print(node.data + ", ");
                    node = node.left;
                }
                if(s.size() > 0) {
                    node = s.pop();
                    node = node.right;
                }
            }
        }
    }
    
    public static void lnr2(TreeNode<Integer> node) {
        if(node != null) {
            Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
            while(node != null || s.size() > 0) {
                while(node != null) {
                    s.push(node);
                    node = node.left;
                }
                if(s.size() > 0) {
                    node = s.pop();
                    System.out.print(node.data + ", ");
                    node = node.right;
                }
            }
        }
    }
    
    public static void lrn2(TreeNode<Integer> node) {
        if(node != null) {
            Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
            Stack<TreeNode<Integer>> t = new Stack<TreeNode<Integer>>();
            while(node != null || s.size() > 0) {
                while(node != null) {
                    s.push(node);
                    t.push(node);
                    node = node.right;
                }
                if(s.size() > 0) {
                    node = s.pop();
                    node = node.left;
                }
            }
            while(t.size() > 0) {
                node = t.pop();
                System.out.print(node.data + ", ");
            }
        }
    }

    
}

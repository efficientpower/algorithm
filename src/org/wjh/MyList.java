package org.wjh;

public class MyList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node<Integer> node3 = new Node<Integer>(3, null);
        Node<Integer> node2 = new Node<Integer>(2, node3);
        Node<Integer> node1 = new Node<Integer>(1, node2);
        Node<Integer> head = new Node<Integer>(0, node1);
        for(Node<Integer> a = head; a != null; a=a.next) {
            System.out.print(a.data +", ");
        }
        System.out.println("\nafter reverse");
//        Node<Integer> t = reverse(head);
//        for(; t != null; t = t.next) {
//            System.out.print(t.data +", ");
//        }
//        System.out.println();
        Node<Integer> y = reverse2(head);
        for(; y != null; y = y.next) {
            System.out.print(y.data +", ");
        }
    }

    public static <T> Node<T> reverse(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> n = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return n;
    }

    public static <T> Node<T> reverse2(Node<T> node){
        if(node == null || node.next == null) {
            return node;
        }
        Node<T> cur = node, prev = null;
        while(cur != null) {
            Node<T> tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
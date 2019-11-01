package org.wjh;

public class HelloList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node<Integer> head = reverse(generate());
        while(head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.println();
        head = reverse2(generate());
        while(head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }

    public static  Node<Integer> generate(){
        Node<Integer> head = new Node<Integer>(0);
        Node<Integer> node = head;
        for(int i=1; i< 20; i++) {
            node.next = new Node<Integer>(i);
            node = node.next;
        }
        return head;
    }

    public static <T> Node<T> reverse(Node<T> node) {
        if(node == null || node.next == null) {
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
        Node<T> next = null;
        Node<T> prev = null;
        while(node != null) {
           next = node.next;
           node.next = prev;
           prev = node;
           node = next;
        }
        return prev;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
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
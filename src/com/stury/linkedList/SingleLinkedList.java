package com.stury.linkedList;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        public T data;
        public Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            // set head node
            Node<T> node = this.head;
            // find last node
            while (node.next != null) {
                node = node.next;
            }
            // add node
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        // Not empty list
        if(head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

}

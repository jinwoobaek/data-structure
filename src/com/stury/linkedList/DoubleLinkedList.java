package com.stury.linkedList;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        public T data;
        public Node<T> prev = null;
        public Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        // 리스트에 아무런 노드도 존재 하지 않을 때
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        }
        // 리스트에 노드가 존재할 때
        else {
            Node<T> node = this.head;
            // 마지막 노드를 찾은 뒤
            while (node.next != null) {
                node = node.next;
            }
            // 마지막 노드를 생성하고
            node.next = new Node<T>(data);
            // 해당 노드의 prev 을 지정해줌으로써 앞의 노드와 이어준다.
            node.next.prev = node;
            // tail 지정
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node.next != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.print(node.data + " ");
        } else {
            System.out.println("리스트에 노드가 존재하지 않습니다.");
        }
    }

    public Node<T> searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) { // while (node != null) 도 가능
                if (node.data == isData) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public Node<T> searchFromTail(T isData) {
        if (this.tail == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public void addFrontNode(T data, T isData) {
        if (this.searchFromHead(data) == null) {
            this.addNode(isData);
            System.out.println(data + "는 존재 하지 않아 리스트 맨 뒤에 추가 하였습니다.");
        } else {
            Node<T> newNode = new Node<T>(isData);
            // data 가 head 노드 인 경우
            if (this.head.data == data) {
                newNode.next = this.head;
                this.head = newNode;
            }
            // head가 아닐경우
            else {
                Node<T> nextNode = this.searchFromHead(data);
                Node<T> prevNode = nextNode.prev;
                newNode.next = nextNode;
                newNode.prev = prevNode;

                prevNode.next = newNode;
                nextNode.prev = newNode;
            }
        }
    }
}

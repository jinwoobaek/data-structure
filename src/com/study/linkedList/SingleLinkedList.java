package com.study.linkedList;

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
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }

            }
            // 검색 결과 해당 data를 가진 노드가 없을 경우
            return null;
        }
    }

    public void addNodeInside(T data, T isData) {
        // isData가 존재하는 노드 뒤에 새로운 노드 삽입
        Node<T> searchedNode = this.search(isData);

        // 검색된 노드가 없다면 맨 뒤 노드에 노드 삽입
        if (searchedNode == null) {
            this.addNode(data);
        }
        // 검색된 노드가 존재하면 그 뒤에 삽입
        else {
            // 검색된 노드의 뒤 노드를 미리 저장
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            // 새로 추가한 노드의 뒤에 기존 nextNode 추가
            searchedNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            // 맨 앞 노드 삭제
            if (node.data == isData) {
                this.head = this.head.next;
                return true;
            }
            // 중간 노드, 마지막 노드 삭제
            else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;

                }
                return false;
            }
        }
    }
}

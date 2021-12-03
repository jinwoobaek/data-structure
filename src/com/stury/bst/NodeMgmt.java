package com.stury.bst;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.value = data;
        }
    }

    public boolean insertNode(int data) {
        // CASE1 : Node 가 하나도 없을때
        if (this.head == null) {
            this.head = new Node(data);
        }
        // CASE2 : Node가 하나 이상 들어가 있을 때
        else {
            Node findNode = this.head;
            while (true) {
                // CASE2-1 : 현재 Node 의 왼쪽에 Node 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                }
                // CASE2-2 : 현재 Node 의 오른쪽에 Node 가 들어가야 할 때
                else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }
}

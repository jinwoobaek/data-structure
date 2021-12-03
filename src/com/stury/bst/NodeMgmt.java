package com.stury.bst;


public class NodeMgmt {
    Node head = null;

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

    public Node search(int data) {
        // CASE1 : Node 가 하나도 없을 때
        if (this.head == null) {
            return null;
        }
        // CASE2 : Node 가 하나 이상 있을 때
        else {
            Node findNode = this.head;
            while (findNode != null) {
                // CASE 2-1 : data 가 루트 노드 일때
                if (findNode.value == data) {
                    return findNode;
                }
                // CASE 2-2 : 찾고자 하는 데이터가 parent Node 보다 작을때
                else if (findNode.value > data) {
                    findNode = findNode.left;
                }
                // CASE 2-3 : 찾고자 하는 데이터가 parent Node 보다 클때
                else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }
}
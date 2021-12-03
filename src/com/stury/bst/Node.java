package com.stury.bst;

public class Node {
    Node left;
    Node right;
    int value;

    public Node(int data) {
        this.left = null;
        this.right = null;
        this.value = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}

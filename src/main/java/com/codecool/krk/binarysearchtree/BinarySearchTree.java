package com.codecool.krk.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Integer value) {
        this.root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void add(Integer data) {
        this.root.add(data);
    }
}

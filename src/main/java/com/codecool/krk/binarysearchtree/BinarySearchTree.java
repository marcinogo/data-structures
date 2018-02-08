package com.codecool.krk.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree(Integer value) {
        this.root = new Node(value);
    }
}

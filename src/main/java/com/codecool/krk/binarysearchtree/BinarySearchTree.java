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

    public boolean contains(Integer value) {
        return this.root.contains(value);
    }

    public void printInOrderPrint() {
        this.root.printInOrderPrint();
    }

    public static BinarySearchTree createBinarySearchTree(int[] sortedArray) throws IllegalArgumentException{
        if (sortedArray == null) {
            throw new IllegalArgumentException();
        }
        
        int middle = (int) Math.floor(sortedArray.length / 2);
        BinarySearchTree newBinarySearchTree = new BinarySearchTree(sortedArray[middle]);

        for (int i = 0; i < middle; i++) {
            newBinarySearchTree.add(sortedArray[i]);
        }

        for (int i = middle + 1; i < sortedArray.length; i++) {
            newBinarySearchTree.add(sortedArray[i]);
        }

        return newBinarySearchTree;
    }
}

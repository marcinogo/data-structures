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

    public Node remove(Integer value) {
        Node toRemove = null;

        if (!contains(value)) {
            return toRemove;
        } else {
            Node parent = this.root;
            Node current = this.root;

            while (current.getValue() != value) {
                parent = current;

                if (current.getValue() < value) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            toRemove = current;

            if (current.getLeft() == null && current.getRight() == null) {
                if (current.equals(this.root)) {
                    this.root = null;
                }

                if (parent.getLeft().equals(current)) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }

            } else if (current.getRight() == null) {
                if(current.equals(this.root)){
                    this.root = current.getLeft();
                }else if(parent.getLeft().equals(current)){
                    parent.setLeft(current.getLeft());
                }else{
                    parent.setRight(current.getLeft());
                }

            } else if (current.getLeft() == null) {
                if(current.equals(this.root)){
                    this.root = current.getRight();
                }else if(parent.getLeft().equals(current)){
                    parent.setLeft(current.getRight());
                }else{
                    parent.setRight(current.getRight());
                }

            } else if(current.getLeft() !=null && current.getRight() !=null) {
                Node successor = getSuccessor(current);
                if (current.equals(this.root)) {
                    this.root = successor;
                } else if (parent.getLeft().equals(current)) {
                    parent.setLeft(successor);
                } else {
                    parent.setRight(successor);
                }
                successor.setLeft(current.getLeft());
            }
        }
        return toRemove;
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

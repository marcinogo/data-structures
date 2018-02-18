package com.codecool.krk.binarysearchtree;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(Integer newData) {
        if (newData <= this.value) {
            if (this.left == null) {
                this.left = new Node(newData);
            } else {
                this.left.add(newData);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(newData);
            } else {
                this.right.add(newData);
            }
        }
    }

    public boolean contains(Integer searchData) {
        if (this.value.equals(searchData)) {
            return true;
        }

        if (searchData < this.value) {
            if (this.left == null) {
                return false;
            }
            return this.left.contains(searchData);
        } else {
            if (this.right == null) {
                return false;
            }
            return this.right.contains(searchData);
        }
    }

    public void printInOrderPrint() {
        if (this.left != null) {
            this.left.printInOrderPrint();
        }

        System.out.println(this.value);

        if (this.right != null) {
            this.right.printInOrderPrint();
        }
    }

    public Node getSuccessor() {
        Node successor = null;
        Node successorParent = null;
        Node current = this.getRight();

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if(!successor.equals(this.getRight())){
            successorParent.setLeft(successor.getRight());
            successor.setRight(this.getRight());
        }
        return successor;
    }
}

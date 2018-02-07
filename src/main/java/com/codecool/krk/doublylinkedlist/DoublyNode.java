package com.codecool.krk.doublylinkedlist;

public class DoublyNode<T> {
    private T data;
    private DoublyNode<T> nextNode;
    private DoublyNode<T> previousNode;

    public DoublyNode() {
    }

    public DoublyNode(T data) {
        this.data = data;
    }
}

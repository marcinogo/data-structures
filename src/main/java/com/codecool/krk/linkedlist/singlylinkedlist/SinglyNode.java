package com.codecool.krk.linkedlist.singlylinkedlist;

public class SinglyNode<T> {
    private T data;
    private SinglyNode<T> nextNode;

    public SinglyNode() {
    }

    public SinglyNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}

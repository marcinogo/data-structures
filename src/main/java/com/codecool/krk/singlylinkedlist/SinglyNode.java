package com.codecool.krk.singlylinkedlist;

public class SinglyNode<T> {
    private T data;
    private SinglyNode<T> nextNode;

    public SinglyNode(T data) {
        this.data = data;
    }
}

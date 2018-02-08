package com.codecool.krk.queue;

public class Node<T> {
    private T data;
    private Node nextNode;

    public Node(T data) {
        this.data = data;
    }
}

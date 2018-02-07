package com.codecool.krk.singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private SinglyNode<T> head;
    private SinglyNode<T> tail;
    private int length;

    public SinglyLinkedList() {
        this.length = 0;
    }

    public SinglyNode<T> getHead() {
        return head;
    }

    public void setHead(SinglyNode<T> head) {
        this.head = head;
    }

    public SinglyNode<T> getTail() {
        return tail;
    }

    public void setTail(SinglyNode<T> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement to keep naming similar to Collection interface implementations
    public int size() {
        return getLength();
    }

    public void append(T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNextNode(newNode);
        }

        this.length++;
        this.tail = newNode;
    }

    public void prepend(T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);

        if (this.tail == null) {
            this.tail = newNode;
        } else {
            newNode.setNextNode(this.head);
        }

        this.length++;
        this.head = newNode;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        SinglyNode<T> current = this.head;

        while (current.getNextNode() != null) {
            if (current.getData().equals(data)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public SinglyNode<T> removeFirst() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SinglyNode<T> toRemove = this.head;
        this.head = this.head.getNextNode();

        this.length--;
        return toRemove;
    }

    public SinglyNode<T> removeLast() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SinglyNode<T> toRemove = this.tail;
        SinglyNode<T> beforeLast = this.head;

        while (beforeLast.getNextNode().equals(this.tail)) {
            beforeLast = beforeLast.getNextNode();
        }

        this.tail = beforeLast;
        this.length--;
        return toRemove;
    }

    public SinglyNode<T> search(T data) {
        if (!contains(data)) {
            return null;
        }

        SinglyNode<T> searchedNode = this.head;

        while (!searchedNode.getData().equals(data)) {
            searchedNode = searchedNode.getNextNode();
        }
        return searchedNode;
    }

    public SinglyNode<T> remove(T data) throws NoSuchElementException {
        if (!contains(data)) {
            throw new NoSuchElementException();
        }

        SinglyNode<T> toRemove = search(data);
        SinglyNode<T> beforeToRemove = this.head;

        if (!toRemove.equals(this.head)) {
            while (!beforeToRemove.getNextNode().equals(toRemove)) {
                beforeToRemove = beforeToRemove.getNextNode();
            }

            beforeToRemove.setNextNode(toRemove.getNextNode());
        } else {
            this.head = this.head.getNextNode();
        }

        this.length--;
        return toRemove;
    }

    public void insert(SinglyNode<T> previousNode, T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);

        newNode.setNextNode(previousNode.getNextNode());
        previousNode.setNextNode(newNode);

        this.length++;
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("");
        SinglyNode<T> temp = this.head;

        while (temp != null) {
            listString.append(" ");
            listString.append(temp.getData());
            temp = temp.getNextNode();
        }
        return listString.toString();
    }
}

package com.codecool.krk.linkedlist.doublylinkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public DoublyNode<T> getHead() {
        return head;
    }

    public void setHead(DoublyNode<T> head) {
        this.head = head;
    }

    public DoublyNode<T> getTail() {
        return tail;
    }

    public void setTail(DoublyNode<T> tail) {
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

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        DoublyNode<T> current = this.head;

        while (current.getNextNode() != null) {
            if (current.getData().equals(data)) {
                return true;
            }
        }

        return false;
    }

    public DoublyNode<T> search(T data) {
        if (!contains(data)) {
            return null;
        }

        DoublyNode<T> searchedNode = this.head;

        while (!searchedNode.getData().equals(data)) {
            searchedNode = searchedNode.getNextNode();
        }
        return searchedNode;
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("");
        DoublyNode<T> temp = this.head;

        while (temp != null) {
            listString.append(" ");
            listString.append(temp.getData());
            temp = temp.getNextNode();
        }
        return listString.toString();
    }

    public void append(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.setPreviousNode(this.tail);
            this.tail.setNextNode(newNode);
        }

        this.length++;
        this.tail = newNode;
    }

    public void prepend(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        if (this.tail == null) {
            this.tail = newNode;
        } else {
            this.head.setPreviousNode(newNode);
            newNode.setNextNode(this.head);
        }

        this.length++;
        this.head = newNode;
    }

    public void insert(DoublyNode<T> previousNode, T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);

        newNode.setPreviousNode(previousNode);
        newNode.setNextNode(previousNode.getNextNode());

        previousNode.getNextNode().setPreviousNode(newNode);
        previousNode.setNextNode(newNode);

        this.length++;
    }

    public DoublyNode<T> removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DoublyNode<T> toRemove = this.head;
        this.head = this.head.getNextNode();
        this.head.setPreviousNode(null);

        this.length--;
        return toRemove;
    }

    public DoublyNode<T> removeLast() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        DoublyNode<T> toRemove = this.tail;
        this.tail = this.tail.getPreviousNode();
        this.tail.setNextNode(null);

        this.length--;
        return toRemove;
    }

    public DoublyNode<T> remove(T data) throws NoSuchElementException {
        if (!contains(data)) {
            throw new NoSuchElementException();
        }

        DoublyNode<T> toRemove = search(data);
        DoublyNode<T> previousNode = toRemove.getPreviousNode();
        DoublyNode<T> nextNode = toRemove.getNextNode();
        
        if (!toRemove.equals(this.head)) {
            previousNode.setNextNode(null);
        } else {
            this.head = nextNode;
        }

        if (!toRemove.equals(this.tail)) {
            nextNode.setPreviousNode(null);
        } else {
            this.tail = previousNode;
        }

        this.length--;
        return toRemove;
    }
}

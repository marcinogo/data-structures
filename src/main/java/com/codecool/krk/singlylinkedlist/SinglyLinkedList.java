package com.codecool.krk.singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private SinglyNode<T> head;
    private SinglyNode<T> last;
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

    public SinglyNode<T> getLast() {
        return last;
    }

    public void setLast(SinglyNode<T> last) {
        this.last = last;
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

        this.length++;

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.last.setNextNode(newNode);
        }

        this.last = newNode;
    }

    public void prepend(T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);

        if (this.last == null) {
            this.last = newNode;
        } else {
            newNode.setNextNode(this.head);
        }

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

        return toRemove;
    }

    public SinglyNode<T> removeLast() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SinglyNode<T> toRemove = this.last;
        SinglyNode<T> beforeLast = this.head;

        while (beforeLast.getNextNode().equals(this.last)) {
            beforeLast = beforeLast.getNextNode();
        }

        this.last = beforeLast;
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

        while (!beforeToRemove.getNextNode().equals(toRemove)) {
            beforeToRemove = beforeToRemove.getNextNode();
        }

        beforeToRemove.setNextNode(toRemove.getNextNode());

        return toRemove;
    }
}

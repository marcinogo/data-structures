package com.codecool.krk.dynamicarray;

public class DynamicArray<T> {
    // specify how many time increase size of dynamicArray
    private final int FACTOR;

    private int size;
    private T[] dynamicArray;

    private int numberOfStoreData;

    public DynamicArray() {
        this.numberOfStoreData = 0;
        this.FACTOR = 2;
        this.size = 16;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public DynamicArray(int size) {
        this.numberOfStoreData = 0;
        this.FACTOR = 2;
        this.size = size;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public DynamicArray(int FACTOR, int size) {
        this.numberOfStoreData = 0;
        this.FACTOR = FACTOR;
        this.size = size;
        this.dynamicArray = (T[]) new Object[this.size];
    }

    public int getFACTOR() {
        return FACTOR;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getDynamicArray() {
        return dynamicArray;
    }

    public void setDynamicArray(T[] dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    public int getNumberOfStoreData() {
        return numberOfStoreData;
    }

    public void setNumberOfStoreData(int numberOfStoreData) {
        this.numberOfStoreData = numberOfStoreData;
    }

    // Implement to keep naming similar to Collection interface implementations
    public int size() {
        return getSize();
    }

    public void add(T data) {
        this.numberOfStoreData++;
        resize();
        this.dynamicArray[this.numberOfStoreData - 1] = data;
    }
}

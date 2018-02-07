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

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);

        return this.dynamicArray[index];
    }

    public T remove() {
        T dataToRemove = this.dynamicArray[this.numberOfStoreData - 1];
        this.dynamicArray[this.numberOfStoreData - 1] = null;
        numberOfStoreData--;

        return dataToRemove;
    }

    public T remove(int index) {
        validateIndex(index);
        T dataToRemove = this.dynamicArray[index];

        for (int i = index; i < this.numberOfStoreData - 2; i++) {
            this.dynamicArray[index] = this.dynamicArray[index + 1];
        }

        this.dynamicArray[this.numberOfStoreData - 1] = null;
        numberOfStoreData--;

        return dataToRemove;
    }

    public void insert(int index, T data) {
        validateIndex(index);

        this.numberOfStoreData++;
        resize();

        for (int i = this.numberOfStoreData - 1; i > index; i--) {
            this.dynamicArray[i] = this.dynamicArray[i - 1];
        }

        this.dynamicArray[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder("");
        for (int i = 0; i < this.numberOfStoreData; i++) {
            arrayString.append(" ");
            arrayString.append(this.dynamicArray[i]);
        }

        return arrayString.toString();
    }

    private void resize() {
        if (this.numberOfStoreData == this.size) {
            this.size = this.size * this.FACTOR;

            this.dynamicArray = copyArray();
        }
    }

    // This can be done by using external library
    private T[] copyArray() {
        T[] biggerArrayCopy = (T[]) new Object[this.size];
        int oldSize = this.dynamicArray.length;

        for (int i = 0; i < oldSize; i++) {
            biggerArrayCopy[i] = this.dynamicArray[i];
        }

        return biggerArrayCopy;
    }

    private void validateIndex(int index) throws ArrayIndexOutOfBoundsException  {
        if (index < 0 || index >= this.numberOfStoreData - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}

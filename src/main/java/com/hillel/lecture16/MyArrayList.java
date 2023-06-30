package com.hillel.lecture16;

//import static java.lang.Class.addAll;

public class MyArrayList implements MyList {

    private static final int INITIAL_CAPACITY = 16;
    private String[] elements = new String[INITIAL_CAPACITY]; // {"qwer", null, null, ... , null}
    private int size = 0;


    @Override
    public void addFirst(String value) {
        resize();
        size++;
        System.arraycopy(elements, 0, elements, 1, size);
        elements[0] = value;

    }

    @Override
    public void addLast(String value) {
        resize();
        elements[size] = value;
        size++;
    }

    private void resize() {
        if (size < elements.length) {
            return;
        }
        String[] tmp = new String[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;

    }

    @Override
    public void add(String value, int index) {
        validateIndex(index);
        size++;
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;

    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public void set(String value, int index) {
        validateIndex(index);
        elements[index] = value;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Wrong index");
        }
    }

    @Override
    public String delete(int index) {
        validateIndex(index);
        String deletedElement = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return deletedElement;

    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += elements[i] + ", ";
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;

        } else {
            return false;
        }
    }

}
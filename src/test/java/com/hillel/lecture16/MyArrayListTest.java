package com.hillel.lecture16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
    private MyArrayList list;

    public void equalsArrays(String[] array) {
        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], list.get(i));
        }
    }

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Test
    void emptyList() {
        // given

        // when

        // then
        Assertions.assertEquals(0, list.size());
        Assertions.assertEquals("", list.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.set("value", 5));
    }

    @Test
    void addLast() {
        // given
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "element#2", "element#3", "element#4"};

        // when

        // then
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("element#0, element#1, element#2, element#3, element#4, ", list.toString());
        equalsArrays(expected);

    }

    @Test
    void addFirst() {

        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        list.addFirst("newElement");
        String[] expected = {"newElement", "element#0", "element#1", "element#2", "element#3", "element#4"};

        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals("newElement, element#0, element#1, element#2, element#3, element#4, ", list.toString());
        equalsArrays(expected);

    }

    @Test
    void add() {
        // given
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "element#2", "qwerty", "element#3", "element#4"};

        // when
        list.add("qwerty", 3);

        // then
        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals("element#0, element#1, element#2, qwerty, element#3, element#4, ", list.toString());
        equalsArrays(expected);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.add("qwerty", -3);
        });
    }

    @Test
    void delete() {
        // given
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        // when
        String deletedElement = list.delete(2);
        String[] expected = {"element#0", "element#1", "element#3", "element#4"};

        // then
        Assertions.assertEquals("element#2", deletedElement);
        Assertions.assertEquals(4, list.size());
        equalsArrays(expected);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.delete(-3);
        });
    }

    @Test
    void isEmpty() {

        boolean result = list.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    void set() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "element#2", "qwerty", "element#4"};
        // when
        list.set("qwerty", 3);
        // then
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("element#0, element#1, element#2, qwerty, element#4, ", list.toString());
        Assertions.assertEquals("qwerty", list.get(3));
        equalsArrays(expected);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.set("qwerty", -3);
        });

    }

    @Test
    void get() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String result = list.get(3);
        String expected = "element#3";
        // when
        Assertions.assertEquals(expected, result);
        // then
        Assertions.assertEquals(5, list.size());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.get(-3);
        });

    }

    @Test
    void size() {

        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        Assertions.assertEquals(5, list.size());
    }

    @Test
    void methodToString() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String expected = "element#0, element#1, element#2, element#3, element#4, ";

        Assertions.assertEquals(expected, list.toString());
        Assertions.assertEquals(5, list.size());

    }
}
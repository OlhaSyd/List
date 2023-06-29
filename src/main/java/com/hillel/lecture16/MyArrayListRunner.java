package com.hillel.lecture16;

import org.junit.Test;

public class MyArrayListRunner {
    public static void main(String[] args) {
        MyList list = new MyArrayList();

        for (int i = 0; i < 18; i++) {
            list.addFirst(String.valueOf(i));
        }


        System.out.println("Size: " + list.size());
        System.out.println("List values: " + list);
        System.out.println(list.get(30));



    }


}

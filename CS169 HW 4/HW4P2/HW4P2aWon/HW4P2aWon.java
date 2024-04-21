package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class HW4P2aWon {

    public static void main(String[] args) {
        ArrayList<Fruit> arr = new ArrayList<>();    // Creates arraylist of fruit
        Date date1 = new Date();
        Date date2 = new Date(12345678);
        Date date3 = new Date(2719897);
        Date date4 = new Date(11111111);
        Date date5 = new Date();
        Fruit fruit1 = new Fruit("Grape", date1);       // Creates different fruits
        Fruit fruit2 = new Fruit("Star Fruit", date2);
        Fruit fruit3 = new Fruit("Grapefruit", date3);
        Fruit fruit4 = new Fruit("Pineapple", date4);
        Fruit fruit5 = new Fruit("Strawberry", date5);
        arr.add(fruit1);                                 // Adds all fruits to arraylist
        arr.add(fruit2);
        arr.add(fruit3);
        arr.add(fruit4);
        arr.add(fruit5);
        System.out.println("Unsorted:");
        for(int i = 0; i < arr.size(); i++) {        // Prints unsorted list
            arr.get(i).prepare();
            arr.get(i).ripeTime();
        }
        Collections.sort(arr);                       // Sorts fruit list
        System.out.println("Sorted:");
        for(int i = 0; i < arr.size(); i++) {        // Prints fruit sorted list
            arr.get(i).prepare();
            arr.get(i).ripeTime();
        }
    }
}

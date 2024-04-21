package com.company;
import java.util.*;
import java.util.Date;


public class HW4P1Won {

    //Purpose: Converts Arraylist of Objects (Strings and Integers) that contains names of types of Object
    //each followed by any parameters to be put in their constructor
    //to an Arraylist of Objects (Food, Fruit, Apple, Orange)
    //with their parameters being put into the object
    //Input: ArrayList of Objects (Strings and Integers)
    //Output: ArrayList of Object (Food, Fruit, Apple, Orange)
    public static ArrayList<Object> convert(ArrayList<Object> arr) {
        ArrayList<Object> result = new ArrayList<>();
        int j;
        Integer x;
        for(int i = 0; i < arr.size(); i++) {
            j = i + 1;
            if(arr.get(i).equals("Food")) {
                if(j == arr.size() || arr.get(j).equals("Food") || arr.get(j).equals("Fruit") ||
                        arr.get(j).equals("Apple") || arr.get(j).equals("Orange")) {
                    result.add(new Food());
                }
                else {
                    result.add(new Food(arr.get(j).toString()));
                    i = j;
                }
            }
            else if(arr.get(i).equals("Fruit")) {
                if(j == arr.size() || arr.get(j).equals("Food") || arr.get(j).equals("Fruit") ||
                        arr.get(j).equals("Apple") || arr.get(j).equals("Orange")) {
                    result.add(new Fruit());
                }
                else {
                    if(!arr.get(j + 1).equals("now")) {
                        x = (Integer)arr.get(j + 1);
                        result.add(new Fruit(arr.get(j).toString(), new Date(x.longValue())));
                    }
                    else {
                        result.add(new Fruit(arr.get(j).toString(), new Date()));
                    }

                    i = j + 1;
                }
            }
            else if(arr.get(i).equals("Apple")) {
                if(j == arr.size() || arr.get(j).equals("Food") || arr.get(j).equals("Fruit") ||
                        arr.get(j).equals("Apple") || arr.get(j).equals("Orange")) {
                    arr.add(new Apple());
                }
                else {
                    if(!arr.get(j).equals("now")) {
                        x = (Integer)arr.get(j);
                        result.add(new Apple(new Date(x.longValue())));
                    }
                    else {
                        result.add(new Apple(new Date()));
                    }
                    i = j;
                }
            }
            else if(arr.get(i).equals("Orange")) {
                if(j == arr.size() || arr.get(j).equals("Food") || arr.get(j).equals("Fruit") ||
                        arr.get(j).equals("Apple") || arr.get(j).equals("Orange")) {
                    result.add(new Orange());
                }
                else {
                    if(!arr.get(j).equals("now")) {
                        x = (Integer)arr.get(j);
                        result.add(new Orange(new Date(x.longValue())));
                    }
                    else {
                        result.add(new Orange(new Date()));
                    }
                    i = j;
                }
            }
        }
        return result;
    }

    //Purpose: Prints out Objects prepare message and ripe time if is a fruit
    //Input: ArrayList of Objects (Food, Fruit, Apple, Orange)
    //Output: None
    public static void printClass(ArrayList<Object> arr) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) instanceof Food) {
                ((Food)arr.get(i)).prepare();
            }

            if(arr.get(i) instanceof Fruit) {
                ((Fruit)arr.get(i)).ripeTime();
            }

        }
    }

    public static void main(String[] args) {
        ArrayList<Object> arr = new ArrayList(Arrays.asList("Food", "Orange", "Fruit", "Papaya",
                (Integer)3932728, "Apple", "now", "Food", "sandwich"));
        ArrayList<Object> result;
        result = convert(arr);
        System.out.println(result.size());
        System.out.println(result);
        printClass(result);
    }
}


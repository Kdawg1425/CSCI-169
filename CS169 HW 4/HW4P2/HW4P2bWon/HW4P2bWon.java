package com.company;
import java.lang.*;

public class HW4P2bWon {

    public static void main(String[] args) {
        SortedList l = new SortedList();
        l.insert(1);
        l.insert(4);
        l.insert(5);
        l.insert(2);
        l.insert(6);
        l.insert(3);
        int i;
        for(Object x : l) {
            i = (int) x;
            System.out.print(i + " ");
        }
    }
}

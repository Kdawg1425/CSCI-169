package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String args[])
    {
        int n, search, array[];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of elements");
        n = in.nextInt();
        array = new int[n];
        System.out.println("Enter " + n + " integers in ascending order");
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();
        SortedList s = new SortedList(array);
        System.out.println("Enter value to find");
        search = in.nextInt();
        in.close();
        int spot = s.binsearch(search);
        if(spot>=0)
            System.out.println(search + " found at index " + spot + ".");
        else
            System.out.println(search + " is not present in the list.\n");

        System.out.println();
        System.out.println("Inserting int 1 into the Sorted Array");
        s.insert(1);
        System.out.println("New Sorted Array");
        s.print();
    }

}

package com.company;
import java.util.Arrays;
import java.util.Iterator;

public class SortedList implements Iterable {

    private int array[];

    public SortedList() {
        array = new int[0];
    }

    public SortedList(int arr[]){
        array = arr.clone();
    }


    // The partition function
    public static int partition(int[] input, int p, int r) {
        int pivot = input[r];
        while ( p < r ) {
            while ( input[p] < pivot )
                p++;
            while ( input[r] > pivot )
                r--;
            if ( input[p] == input[r] )
                p++;
            else if ( p < r ) {
                int tmp = input[p];
                input[p] = input[r];
                input[r] = tmp;
            }
        }
        return r;
    }

    // The quicksort recursive function
    public static void quicksort(int[] input, int p, int r)
    {
        if ( p < r )
        {
            int j = partition(input, p, r);
            quicksort(input, p, j-1);
            quicksort(input, j+1, r);
        }
    }

    public void sort(){
        quicksort(array, 0, array.length-1);
    }

    //Input: one integer
    //Output: A Sorted Array with the new inserted integer.
    public void insert(int n) {
        int temp[];
        temp = new int[array.length+1];
        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[temp.length-1] = n;
        array = temp.clone();
        sort();
    }

    // Binary search function
    public int binsearch(int search){
        int n=array.length;
        int first, last, middle;
        first  = 0;
        last   = n - 1;
        middle = (first + last)/2;
        while( first <= last )
        {
            if ( array[middle] < search )
                first = middle + 1;
            else if ( array[middle] == search )
            {
                return middle;
            }
            else
                last = middle - 1;
            middle = (first + last)/2;
        }
        return -1;
    }


    //Input: None
    //Output: Prints out elements of Sorted Array
    public void print() {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public Iterator<Integer> iterator() {
        return Arrays.stream(array).iterator();
    }

}

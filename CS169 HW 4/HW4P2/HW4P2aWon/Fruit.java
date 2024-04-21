package com.company;

import java.util.Date;

public class Fruit extends Food implements Comparable{
    private Date ripe;

    public Fruit() {
        super("fruit");
    }

    public Fruit(String n, Date r) {
        super(n);
        ripe = r;
    }

    public void ripeTime() {
        System.out.println("You can eat it on " + ripe);
    }

    //Purpose Implements function from comparable interface
    //Input: Object
    //Output: Object is cast to fruit. If object's date comes after fruit's date, returns positive number.
    //        If object's date comes before fruit's date, returns negative number. If dates are equal, returns 0
    public int compareTo(Object obj) {
        Fruit fruit = (Fruit) obj;
        if(ripe.after(fruit.ripe)) {
            return 1;
        }
        else if(ripe.before(fruit.ripe)) {
            return -1;
        }
        else {
            return 0;
        }
    }

}

package com.company;


import java.util.Date;

public class Fruit extends Food{
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
}

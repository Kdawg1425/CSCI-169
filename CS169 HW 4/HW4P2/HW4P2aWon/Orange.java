package com.company;

import java.util.Date;

public class Orange extends Fruit {
    public Orange() {
        super("orange", null);
    }

    public Orange(Date r) {
        super("orange", r);
    }

    @Override
    public void prepare() {
        System.out.println("Peel the orange");
    }

}

package com.company;
import java.util.Date;

public class Orange extends Fruit{

    public Orange() {
        super("orange", new Date());
    }

    public Orange(Date r) {
        super("orange", r);
    }

    @Override
    public void prepare() {
        System.out.println("Peel the orange");
    }
}

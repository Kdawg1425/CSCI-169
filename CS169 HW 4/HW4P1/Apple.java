package com.company;
import java.util.Date;

public class Apple extends Fruit {

    public Apple() {
        super("apple", new Date());
    }

    public Apple(Date r) {
        super("apple", r);
    }

    @Override
    public void prepare() {
        System.out.println("Core the apple");
    }
}

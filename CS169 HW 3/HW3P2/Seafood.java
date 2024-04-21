package com.company;

public class Seafood extends Food {

    public Seafood() {
        super("seafood");
    }

    public Seafood(String n) {
        super(n);
    }

    @Override
    public void prepare() {
        System.out.println("Peel the " + super.name);
    }
}

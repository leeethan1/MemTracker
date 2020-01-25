package com.example.memtracker;

import java.io.Serializable;

/**
 * @author Abhiram Saran
 * @version 25 Jan 2020
 */
public class Person implements Serializable {

    private String name;

    public Person(String name) throws NullPointerException, IllegalArgumentException {
        this.name = name;

        if (name.equals(null)) throw new NullPointerException();
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object object) {

        if (object instanceof Person) {
            return ((Person) object).name.equals(this.name);
        } else return false;
    }

    public String toString() {
        String n = getName();

        String s = "Person[" + n + "]";
        return s;
    }
}

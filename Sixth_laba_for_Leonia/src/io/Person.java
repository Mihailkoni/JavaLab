package io;

import java.io.Serializable;

public class Person implements Serializable {
     private String firstName;
     private String lastName;
     private int birthYear;
     private String address;

    public Person(String firstName, String lastName, int birthYear, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return String.format("%-20s %-20s %-15d %-30s",firstName,lastName,birthYear,address);
    }
}

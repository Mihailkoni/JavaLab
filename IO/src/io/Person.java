package io;

import java.io.Serializable;

public record Person(String firstName, String lastName, int birthYear, String address) implements Serializable {

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-15d %-30s", firstName, lastName, birthYear, address);
    }
}

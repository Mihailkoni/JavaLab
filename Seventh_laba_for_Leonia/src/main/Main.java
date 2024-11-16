package main;

import philosophers.Bowl;
import philosophers.Philosopher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl();

        ArrayList<Philosopher> philosophers = new ArrayList<>();

        for(int i = 1; i < 6;i++){
            philosophers.add(new Philosopher(bowl,"Philosopher " + i));
        }

        for(Philosopher philosopher:philosophers){
            philosopher.start();
        }
    }
}

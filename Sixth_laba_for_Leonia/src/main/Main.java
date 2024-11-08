package main;
import io.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        personList.add(new Person("Korikov","Mihail",2002,"г.Ангарск,85 квартал,дом 23б,квартира 77"));
        personList.add(new Person("Sergeeva","Victoria", 2003,"г.Благовещенск, улица Ленина, дом 52, квартира 79"));

        try {
            personList.saveToFile("persons.txt");
            System.out.println("Data saved");
        }catch (IOException e){
            System.out.println("Error saving data");
        }

        try {
            personList.loadFromFile("persons.txt");
            for(Person p: personList.getPersonList()){
                System.out.println(p);
            }
        }catch (IOException e){
            System.out.println("Error loading file");
        }


    }
}

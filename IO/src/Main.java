import io.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PersonList savePersonList = new PersonList();
        PersonList loadPersonList = new PersonList();

        savePersonList.add(new Person("Kориков","Михаил",2002,"г.Ангарск,85 квартал,дом 23б,квартира 77"));
        savePersonList.add(new Person("Сергеева","Виктория", 2003,"г.Благовещенск, улица Ленина, дом 52, квартира 79"));

        System.out.println("SAVE TO FILE");
        try {
            savePersonList.saveToFile("IO\\src\\persons.txt");
            System.out.println("Data saved");
        }catch (IOException e){
            System.out.println("Error saving data");
        }

        System.out.println("LOAD FROM FILE");
        try {
            loadPersonList.loadFromFile("IO\\src\\persons.txt");
            for(Person p: loadPersonList.getPersonList()){
                System.out.println(p);
            }
        }catch (IOException e){
            System.out.println("Error loading file");
        }
    }
}

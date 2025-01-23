package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void add(Person person){
        personList.add(person);
    }

    public void saveToFile(String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(String.format("%-20s %-20s %-15s %-30s","First Name", "Last Name", "Birth Year", "Address"));
            writer.newLine();
            writer.write("-----------------------------------------------------------------");
            writer.newLine();
            for(Person person : personList){
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            reader.readLine(); // пропускаем первые строки
            reader.readLine();
            while ((line = reader.readLine()) != null){
                String[] data = line.trim().split("\\s{2,}");
                if(data.length == 4){
                    personList.add(new Person(data[0],data[1],Integer.parseInt(data[2]),data[3]));
                }
            }
        }

    }

    public List<Person> getPersonList(){
        return personList;
    }
}
